// export function showCancelForm(id) {
//     // Ẩn tất cả các form trước khi hiển thị form mới
//     var forms = document.getElementsByClassName("cancel-form");
//     for (var i = 0; i < forms.length; i++) {
//         forms[i].style.display = "none";
//     }

//     // Hiển thị form cho id tương ứng
//     var cancelForm = document.getElementById("cancelForm");
//     cancelForm.style.display = "block";

//     // Thêm thông tin id vào form để xác định người cần hủy
//     var hiddenInput = document.createElement("input");
//     hiddenInput.type = "hidden";
//     hiddenInput.name = "cancelId";
//     hiddenInput.value = id;
//     cancelForm.appendChild(hiddenInput);
// }

export function cancelSubmit(event) {
    event.preventDefault();

    // Lấy thông tin id từ form
    var cancelId = document.querySelector("#cancelForm [name='cancelId']").value;

    // Lấy nguyên nhân từ input
    var reason = document.getElementById("reason").value;

    // Thực hiện các bước hủy, ví dụ: gửi yêu cầu hủy đến máy chủ
    console.log("Hủy người có ID " + cancelId + " với nguyên nhân: " + reason);

    // Ẩn form sau khi hủy
    document.getElementById("cancelForm").style.display = "none";
}