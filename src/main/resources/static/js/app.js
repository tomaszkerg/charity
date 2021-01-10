document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // TODO: get data from inputs and show them in summary

    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }

  const buttonSummary = document.getElementById("summaryButton");
  buttonSummary.addEventListener("click", function updateConfirmation(){
    const sack = document.querySelector("#quantityBags").value;
    let categories = document.querySelectorAll('input[name="categories"]:checked ~ span.description');
    let sumOfCategories = "";
    let category;
    for(let i=0; categories[i]; ++i){
      if(categories[i].innerHTML != null){
        category = categories[i].innerHTML;
      }
      sumOfCategories += category+"; ";
    }
    sumOfCategories = sumOfCategories.substring(0,sumOfCategories.length-2);
    document.getElementById("bags-qty").innerHTML = sack+ " worków zawierających: "+sumOfCategories;

    const institution = document.querySelector('input[name="institution"]:checked ~ span.description div.title').innerHTML;
    document.getElementById("institution-event").innerHTML = institution;

    const street = document.querySelector('#street').value;
    document.getElementById("street-event").innerHTML = 'ulica: ' + street;
    const city = document.querySelector('#city').value;
    document.getElementById("city-event").innerHTML = 'miasto: ' + city;
    const zipCode = document.querySelector('#zipCode').value;
    document.getElementById("zipcode-event").innerHTML = 'kod pocztowy: ' + zipCode;
    const phone = document.querySelector('#phone').value;
    document.getElementById("phone-event").innerHTML = 'telefon: ' + phone;
    const pickUpDate = document.querySelector('#date').value;
    document.getElementById("date-event").innerHTML = 'data: ' + pickUpDate;
    const pickUpTime = document.querySelector('#time').value;
    document.getElementById("time-event").innerHTML = 'czas: ' + pickUpTime;

    const pickUpComment = document.querySelector('#comment-event').value;
    if (pickUpComment === ""){
      document.getElementById("comment").innerHTML = "uwagi: Brak uwag"
    } else {
      document.getElementById("comment").innerHTML = 'uwagi: ' + pickUpComment;
    }
  })
});