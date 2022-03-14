const login = document.querySelector(".login");
const logout = document.querySelector(".logout")

//header 登入 登出
login.addEventListener("click",e =>{
    Swal.fire({
        title: '請輸入帳號密碼',
        html:
        '<input id="swal-input1" class="swal2-input" placeholder="account">' +
        '<input id="swal-input2" class="swal2-input" placeholder="password"><br>'+
        '<a href="#">申請帳號</a><br>'+
        '<a href="">忘記密碼</a>',
        showCancelButton: true,
        reverseButtons: true
      })
    
})
$(".logout").click(e =>{
  Swal.fire({
    title: '已登出',
  })
})

// //header 捐贈紀錄
// function autoclick() {
//   $('#donateRecord').get(0).click();

// }
// $('.header-donateRecord').click(e=>{
//       setTimeout(function(){
//           autoclick();
//        },5000)
// })

// //header 我要募集物資
// function autoclick2() {
//   $('#storeArea').get(0).click();
// }
// $('.header-raise').click(e=>{
//   setTimeout(function(){
//       autoclick2();
//    },100)
// })