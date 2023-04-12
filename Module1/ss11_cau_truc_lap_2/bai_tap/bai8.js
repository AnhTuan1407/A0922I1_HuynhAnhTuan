function number() {
    let nhap1 = parseInt(prompt("Nhập vào khoảng thứ 1:"));
    let nhap2 = parseInt(prompt("Nhập vào khoảng thứ 2:"));
    let nhap3 = parseInt(prompt("Nhập vào số dự đoán"));
    let nhap4;
    let re1 = Math.floor(Math.random() * nhap2) + nhap1;
    count = 0;
    while (count < 3) {
        if (nhap3 === re1) {
            alert("Chúc mừng du đã đúng \n Phần thưởng là cái nịt.");
            break;
        } else {
            alert("Sai rồi bạn ê.")
            nhap4 = parseInt(prompt("Đoán lại đi bạn ê."))
            count++;
            if (nhap4 === re1) {
                alert("Chúc mừng du đã đúng \n Phần thưởng là cái nịt.")
                break;
            } else {
                alert("Sai rồi bạn ê.")
                nhap4 = parseInt(prompt("Đoán lại đi bạn ê."))
                count++;
            }
                count++;
        }
        count++;
        alert("Vui lòng nạp vào lần đầu để có thêm lượt");
    }
}