var data = JSON.parse(localStorage.getItem("globalData"));

function loadData() {
  // console.log(data);

  // if (data.length == 0)
  var menuList = document.getElementById("menu-list");
  let text = `<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Active</th>
    <th>Date of Launch</th>
    <th>Category</th>
    <th>Free Delivery</th>
    <th>Action</th>
    </tr>`;

  data.forEach((item) => {
    text =
      text +
      `<tr> <td>${item.name}</td>
        <td>${item.price}</td>
        <td>${item.active}</td>
        <td>${item.dateOfLanuch}</td>
        <td>${item.category}</td>
        <td>${item.freedelivery}</td>
        <td><a href="../Pages/editItem.html"><input type="button" data-name=${item.name} data-cost=${item.price} value = "Edit item" onclick="editItem()" class = "btn-cart"/><a></td></tr>`;
  });
  menuList.innerHTML = text;
}

loadData();

function editItem() {
  localStorage.setItem("editItem", document.activeElement.dataset.name);
  console.log(localStorage.getItem("editItem"));
}
