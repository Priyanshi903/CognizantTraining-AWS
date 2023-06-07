var itemCountSpan = document.getElementById("item-count");
var totalCostSpan = document.getElementById("total-cost");

var data = JSON.parse(localStorage.getItem("globalData"));
var cartList = JSON.parse(localStorage.getItem("cart-list"));

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

var menuList = document.getElementById("menu-list");
let text = `<tr>
<th>Name</th>
<th>Free Delivery</th>
<th>Price</th>
<th>Category</th>
<th>Action</th>
</tr>`;

data.forEach((item) => {
  text =
    text +
    `<tr> <td>${item.name}</td>
    <td>${item.freedelivery}</td>
    <td>${item.price}</td>
    <td>${item.category}</td>
    <td><input type="button" data-name=${item.name} data-cost=${item.price} value = "Add to Cart" onclick="addToCart()" class = "btn-cart"/></td></tr>`;
});

menuList.innerHTML = text;
itemCountSpan.innerHTML = getCartCount(cartList);
totalCostSpan.innerHTML = getCartCost(cartList);

function addToCart() {
  var newItem = data.find(
    (item) => item.name == document.activeElement.dataset.name
  );

  //updating the cartListarry
  if (cartList[newItem.name] == undefined) cartList[newItem.name] = 1;
  else cartList[newItem.name]++;

  localStorage.setItem("cart-list", JSON.stringify(cartList));

  itemCountSpan.innerHTML = getCartCount(cartList);
  totalCostSpan.innerHTML = getCartCost(cartList);
  console.log(getCartCount(cartList));

  // console.log(cartList);
  // var x = JSON.parse(localStorage.getItem("cart-list"));
  // console.log(x);
}
