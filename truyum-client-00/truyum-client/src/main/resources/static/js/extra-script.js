
//current data.
var currItems = new Array(
    {"id" : 1, "name" : "Sandwich", "price" : "99.00", "active" : "Yes", "dateofLaunch" : "2017-03-15", "category" : "Main Course", "freeDelivery" : "Yes"},
    {"id" : 2,"name" : "Burger", "price" : "129.00", "active" : "Yes", "dateofLaunch" : "2017-12-23", "category" : "Main Course", "freeDelivery" : "No"},
    {"id" : 3,"name" : "Pizza", "price" : "149.00", "active" : "Yes", "dateofLaunch" : "2017-08-21", "category" : "Main Course", "freeDelivery" : "No"},
    {"id" : 4,"name" : "French Fries", "price" : "57.00", "active" : "No", "dateofLaunch" : "2017-07-02", "category" : "Starters", "freeDelivery" : "Yes"},
    {"id" : 5,"name" : "Chocolate Brownie", "price" : "32.00", "active" : "Yes", "dateofLaunch" : "2022-11-02", "category" : "Dessert", "freeDelivery" : "Yes"}
);

function loadData(){
    currItems = JSON.stringify(currItems);
    localStorage.setItem("currArr",currItems);
}
// changed data from edit form to update the data  
function updateMenuDetails(){
    var menuItemsList = JSON.parse(localStorage.getItem("currArr"));
    var menuInd = parseInt(localStorage.getItem("currentId"));
    menuItemsList[menuInd-1].name = document.getElementById("field-name").value;
    menuItemsList[menuInd-1].price = document.getElementById("field-price").value;
    if(document.getElementById("field-active-yes").checked){
        menuItemsList[menuInd-1].active = "Yes";
    }
    else if(document.getElementById("field-active-no").checked){
        menuItemsList[menuInd-1].active = "No";
    }
    menuItemsList[menuInd-1].dateofLaunch = document.getElementById("field-date").value;
    menuItemsList[menuInd-1].category = document.getElementById("field-category").value;
    if(document.getElementById("field-delivery").selected){
        menuItemsList[menuInd-1].freeDelivery = "Yes";
    }
    else{
        menuItemsList[menuInd-1].freeDelivery = "No";
    }
    localStorage.setItem("currArr",JSON.stringify(menuItemsList));
    window.location.replace("edit-menu-item-status.html");
    return false;
}
// changing the date format..
function changeFormat(x){
    return x.split("-").reverse().join("/");
}
//updating data to the main menu
function loadMenuItems(){
    //loadData();
    var menuItems = JSON.parse(localStorage.getItem("currArr"));
    console.log(menuItems);
    var menuId = document.getElementById("menu-table-body");
    menuId.innerHTML = menuItems.map(i =>
        "<tr> <td>"+i.name+"</td> <td>Rs. "+i.price+"</td> <td>"+i.active+"</td> <td>"+ changeFormat(i.dateofLaunch)
        +"</td> <td>"+i.category+"</td> <td>"+i.freeDelivery+"</td> <td><a onclick = 'nextPage("+i.id+")' id='itemLink'>Edit</a> </td></tr>").join("");
}

// updating the data in the edit form
function uploadDetails(id){
    var b = localStorage.getItem("currentId");
    var menuItems = JSON.parse(localStorage.getItem("currArr"));
    var name = document.getElementById("field-name");
    var price = document.getElementById("field-price");
    var activeYes = document.getElementById("field-active-yes");
    var activeNo = document.getElementById("field-active-no");
    var cDate = document.getElementById("field-date");
    var ccategory = document.getElementById("field-category");
    var details = document.getElementById("field-delivery");
    //upadating values
    name.value = menuItems[b-1].name; 
    price.value = menuItems[b-1].price;
    if(menuItems[b-1].active == "Yes"){
        activeYes.checked = true;
    }else{
        activeNo.checked = true;
    } 
    for(var ind=0;ind < ccategory.options.length;ind++){
        //alert(ccategory.options[ind].value);
        if(ccategory.options[ind].value === menuItems[b-1].category){
            ccategory.options[ind].selected = true;
            break; 
        }
    }
    if(menuItems[b-1].freeDelivery === "Yes"){
        details.checked = true;
    }
    else{
        details.checked = false;
    }
    document.getElementById("field-date").value = menuItems[b-1].dateofLaunch;
}
// storing the id  into local storage 
function nextPage(id){
    a = id;
    localStorage.setItem("currentId",a);
    window.open("edit-menu-item.html",'_self'); 
}

//updateing customer menu page details
function loadCustomerMenuItems(){
    console.log("vijay");
    var menuItems = JSON.parse(localStorage.getItem("currArr"));
    console.log(menuItems);
    var menuId = document.getElementById("menu-table-body");
    menuId.innerHTML = menuItems.map(i =>
        "<tr> <td>"+i.name+"</td> <td>"+i.freeDelivery+"</td> <td> Rs. "+i.price+"</td> <td>"+
        i.category+"</td> </td> <td><a onclick = 'nextPage("+i.id+")' id='itemLink'>Add to Cart</a> </td></tr>").join("");
    console.log("vijay");
}
