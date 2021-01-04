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

  const summaryB = document.getElementById("summaryButton");

  summaryB.addEventListener("click", function () {

    const bagsQty = document.getElementById("bags-qty");

    // const institutionEvent = document.getElementById("institution-event");
    // const categoriesEvent = document.getElementById("categories-event");
    const streetEvent = document.getElementById("street-event");
    const cityEvent = document.getElementById("city-event");
    const zipCodeEvent = document.getElementById("zipCode-event");
    const phoneEvent = document.getElementById("phone-event");
    const dateEvent = document.getElementById("date-event");
    const timeEvent = document.getElementById("time-event");
    const commentEvent = document.getElementById("comment-event");

    const quantity = document.getElementById("quantity");
    //
    // const institution = document.querySelector('input[class="checkboxRadio"]:checked ~ span.description div.title').innerHTML;
    // const inputElements = document.querySelectorAll('input[name="categories"]:checked ~ span.description');
    const street = document.getElementById("street");
    const city = document.getElementById("city");
    const zipCode = document.getElementById("zipCode");
    const phone = document.getElementById("phone");
    const date = document.getElementById("date");
    const time = document.getElementById("time");
    const comment = document.getElementById("comment");

    const newRow = document.createElement("span");
    // const institutionNew = document.createElement("span");
    // const categoriesNew = document.createElement("span");
    const streetNew = document.createElement("span");
    const cityNew = document.createElement("span");
    const zipCodeNew = document.createElement("span");
    const phoneNew = document.createElement("span");
    const dateNew = document.createElement("span");
    const timeNew = document.createElement("span");
    const commentNew = document.createElement("span");



    // var checkedValue = "";
    // var categories;
    // for(var i=0; inputElements[i]; ++i){
    //   if(inputElements[i].innerHTML){
    //     categories = inputElements[i].innerHTML;
    //     checkedValue +=  categories + ", " ;
    //   }
    // }
    //
    // console.log(
    //     checkedValue
    //
    //     ,quantity.value
    //     ,street.value
    //     ,city.value
    //     ,zipCode.value
    //     ,phone.value
    //     ,date.value
    //     ,time.value
    //     ,comment.value
    // )

    newRow.innerText = `${quantity.value}`
    // institutionNew.innerText = institution;
    // categoriesNew.innerText = checkedValue;
    streetNew.innerText = `${street.value} `
    cityNew.innerText = `${city.value} `
    zipCodeNew.innerText = `${zipCode.value} `
    phoneNew.innerText = `${phone.value} `
    dateNew.innerText = `${date.value} `
    timeNew.innerText = `${time.value} `
    commentNew.innerText = `${comment.value} `



    bagsQty.appendChild(newRow)
    // institutionEvent.appendChild(institutionNew)
    // categoriesEvent.appendChild(categoriesNew)
    streetEvent.appendChild(streetNew)
    cityEvent.appendChild(cityNew)
    zipCodeEvent.appendChild(zipCodeNew)
    phoneEvent.appendChild(phoneNew)
    dateEvent.appendChild(dateNew)
    timeEvent.appendChild(timeNew)
    commentEvent.appendChild(commentNew)
  })

  // const ret = document.getElementById("ret");
  // ret.addEventListener("click", function () {
  //   var bagsQty = document.getElementById("bags-qty").lastElementChild;
  //   var institutionEvent = document.getElementById("institution-event").lastElementChild;
  //   var categoriesEvent = document.getElementById("categories-event").lastElementChild;
  //   var streetEvent = document.getElementById("street-event").lastElementChild;
  //   var cityEvent = document.getElementById("city-event").lastElementChild;
  //   var zipCodeEvent = document.getElementById("zipCode-event").lastElementChild;
  //   var phoneEvent = document.getElementById("phone-event").lastElementChild;
  //   var dateEvent = document.getElementById("date-event").lastElementChild;
  //   var timeEvent = document.getElementById("time-event").lastElementChild;
  //   var commentEvent = document.getElementById("comment-event").lastElementChild;
  //
  //   bagsQty.innerHTML = "";
  //   institutionEvent.innerHTML = "";
  //   categoriesEvent.innerHTML = "";
  //   streetEvent.innerHTML = "";
  //   cityEvent.innerHTML = "";
  //   zipCodeEvent.innerHTML = "";
  //   phoneEvent.innerHTML = "";
  //   bagsQty.innerHTML = "";
  //   dateEvent.innerHTML = "";
  //   timeEvent.innerHTML = "";
  //   commentEvent.innerHTML = "";
  // })




});