var globalData = JSON.parse(localStorage.getItem("globalData"));
var currentItem = localStorage.getItem("editItem");

currentItem = globalData.filter((item) => item.name == currentItem)[0];
globalData = globalData.filter((item) => item.name != currentItem.name);

const itemName = document.getElementById("itemName");
itemName.setAttribute("value", currentItem.name);

const price = document.getElementById("price");
price.setAttribute("value", currentItem.price);

const radioButton = document.getElementsByName("active");
radioButton.forEach((item) => {
  if (currentItem.active == item.id) item.checked = 1;
});

const category = document.getElementById("category");
category.value = currentItem.category;

const date = document.getElementById("dateOfLanuch");
let today = new Date().toJSON().slice(0, 10);

const freeDelivery = document.getElementById("freeDelivery");
if (currentItem.freedelivery == "Yes") freeDelivery.checked = true;
else freeDelivery.checked = false;
date.setAttribute("value", today);

function submitItem() {
  currentItem.name = itemName.value;
  currentItem.price = price.value;
  radioButton.forEach((item) => {
    if (item.checked) currentItem.active = item.id;
  });
  currentItem.category = category.value;
  currentItem.dateOfLanuch = date.value;
  currentItem.freedelivery = freeDelivery.checked ? "Yes" : "No";
  globalData.push(currentItem);
  console.log(freeDelivery.checked);
  localStorage.setItem("globalData", JSON.stringify(globalData));
  window.location.href = "./adminPage.html";
}
