let x = 1;

function up() {
    x += 1;
    document.getElementById("1").innerText = x;
}

function down() {
    x -= 1;
    document.getElementById("1").innerHTML = x;
    let sum = document.getElementById("price");
    sum = sum.value * x;
    document.getElementById("price").innerHTML = sum;

}

// function price(){
//    let sum =document.getElementById("price");
//    let k =document.getElementById("1");
//    sum=sum*k;
//     document.getElementById("price").innerHTML = sum;
// }

// function getFilterBrand(brandId) {
//     let xhttp = new XMLHttpRequest();
//     xhttp.onload = function () {
//     }
//     xhttp.open("POST", "/api/filterBrand");
//     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     xhttp.send("brandId=" + brandId);
//
// }
