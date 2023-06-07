var hero = document.getElementById("hero");

var data = JSON.parse(localStorage.getItem("globalData"));
var cartList = JSON.parse(localStorage.getItem("cart-list"));

function loadEmptyCart() {
  hero.innerHTML =
    "<h2>Oops! It looks like your cart is empty<br>Please add item to your cart</h2>";
}

function getCartCount(cartList) {
  var count = 0;
  for (x of Object.values(cartList)) count += x;
  return count;
}

function getItemValue(item) {
  for (var i = 0; i < data.length; i++) {
    if (data[i].name == item) return data[i].price;
  }
}

function getCartCost(cartList) {
  var cost = 0;
  var items = Object.keys(cartList);
  for (x of items) cost += cartList[x] * getItemValue(x);
  return cost;
}

function loadData() {
  var selecteditem = Object.keys(cartList);
  data = data.filter((item) => selecteditem.includes(item.name));
  // console.log(data);

  // if (data.length == 0)
  var menuList = document.getElementById("menu-list");
  let text = `<tr>
  <th>Name</th>
  <th>Free Delivery</th>
  <th>Price</th>
  <th>Quantity</th>
  <th>Action</th>
  </tr>`;

  data.forEach((item) => {
    if (cartList[item.name] != 0) {
      text =
        text +
        `<tr> <td>${item.name}</td>
      <td>${item.freedelivery}</td>
      <td>${item.price}</td>
      <td>${cartList[item.name]}</td>
      <td><input type="button" data-name=${item.name} data-cost=${
          item.price
        } value = "Delete item" onclick="deleteItem()" class = "btn-cart"/></td></tr>`;
    }
  });
  menuList.innerHTML = text;
}

if (getCartCount(cartList) == 0) loadEmptyCart();
else loadData();

function deleteItem() {
  // var del = document.querySelectorAll(".btn-cart");
  // console.log(del);
  var x = document.activeElement.dataset.name;
  cartList[x]--;
  localStorage.setItem("cart-list", JSON.stringify(cartList));
  // var abc = JSON.parse(localStorage.getItem("cart-list"));
  // console.log(abc);

  console.log(cartList);
  if (getCartCount(cartList) != 0) loadData();
  else loadEmptyCart();
}
