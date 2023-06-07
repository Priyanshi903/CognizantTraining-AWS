localStorage.setItem("cart-list", JSON.stringify({}));

// console.log("index page");
if (localStorage.getItem("gobalData") == null) {
  const data = [
    {
      name: "Choco",
      price: 200,
      active: "Yes",
      dateOfLanuch: "10/11/2020",
      category: "Icecream",
      freedelivery: "Yes",
    },
    {
      name: "Pineapple",
      price: 300,
      active: "Yes",
      dateOfLanuch: "11/02/2020",
      category: "Juice",
      freedelivery: "No",
    },
    {
      name: "BlackCurrent",
      price: 500,
      active: "No",
      dateOfLanuch: "10/02/2020",
      category: "Icecream",
      freedelivery: "Yes",
    },
    {
      name: "DarkChoco",
      price: 400,
      active: "Yes",
      dateOfLanuch: "10/02/2020",
      category: "Icecream",
      freedelivery: "Yes",
    },
  ];
  localStorage.setItem("globalData", JSON.stringify(data));
}

// var x = JSON.parse(localStorage.getItem("data"));
// console.log(x);
