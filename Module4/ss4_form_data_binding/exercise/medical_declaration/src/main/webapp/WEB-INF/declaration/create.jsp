<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28/05/2023
  Time: 11:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Medical Declaration</title>
    <style>
        .note {
            color: red;
        }
    </style>
</head>
<body>
<div style="text-align: center">
    <h1>TỜ KHAI Y TẾ</h1>
    <h2>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
        DICH BÊNH TRUYỀN NHIỄM</h2>
    <h4 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình
        sự</h4>
</div>
<form:form action="/create" method="post" modelAttribute="declaration">

    <h3>Họ và tên(Ghi chữ IN HOA)<span class="note">(*)</span></h3>
    <form:input path="name" cssStyle="width: 100%"/>
    <br>
    <table style="width: 100%">
        <tr style="text-align: left">
            <th>Năm sinh<span class="note">(*)</span></th>
            <th>Giới tính<span class="note">(*)</span></th>
            <th>Quốc tịch<span class="note">(*)</span></th>
        </tr>

        <tr>
            <td style="width: 33.3%"><form:input path="yearOfBirth" cssStyle="width: 500px"/></td>
            <td style="width: 33.3%"><form:select path="gender" items="${genderList}" cssStyle="width: 500px"/></td>
            <td style="width: 33.3%"><form:input path="nationality" cssStyle="width: 500px"/></td>
        </tr>
    </table>
    <%--    <h3>Năm sinh: </h3>--%>
    <%--    <form:textarea path="yearOfBirth"/>--%>
    <%--    <h3>Giới tính: </h3>--%>
    <%--    <form:select path="gender" items="${genderList}"/>--%>
    <%--    <h3>Quốc tịch: </h3>--%>
    <%--    <form:textarea path="nationality"/>--%>

    <h3>Số CMND<span class="note">(*)</span></h3>
    <form:input path="identifyCard" cssStyle="width: 100%"/>


    <h3>Thông tin đi lại<span class="note">(*)</span></h3>
    <form:radiobuttons path="vehicle" items="${vehicleList}"/>


    <h3>Số hiệu phương tiện: </h3>
    <form:input path="licensePlate" cssStyle="width: 100%"/>

    <table style="width: 100%">
        <tr style="text-align: left">
            <th>Ngày khởi hành<span class="note">(*)</span></th>
            <th>Ngày kết thúc<span class="note">(*)</span></th>
        </tr>

        <tr>
            <td style="width: 50%"><form:input path="startDate" cssStyle="width: 750px"/></td>
            <td style="width: 50%"><form:input path="endDate" cssStyle="width: 750px"/></td>
        </tr>
    </table>

    <%--    <h3>Ngày khởi hành<span class="note">(*)</span></h3>--%>
    <%--    <form:input path="startDate" cssStyle="width: 500px" />--%>


    <%--    <h3>Ngày kết thúc<span class="note">(*)</span></h3>--%>
    <%--    <form:input path="endDate" cssStyle="width: 500px" />--%>

    <table style="width: 100%">
        <tr style="text-align: left">
            <th>Tỉnh/thành phố<span class="note">(*)</span></th>
            <th>Quận/huyện<span class="note">(*)</span></th>
            <th>Phường/xã<span class="note">(*)</span></th>
        </tr>

        <tr>
            <td style="width: 33.3%"><form:input path="province" cssStyle="width: 500px"/></td>
            <td style="width: 33.3%"><form:input path="district" cssStyle="width: 500px"/></td>
            <td style="width: 33.3%"><form:input path="ward" cssStyle="width: 500px"/></td>
        </tr>
    </table>

    <%--    <h3>Tỉnh/thành phố: </h3>--%>
    <%--    <form:input path="province" cssStyle="width: 500px" />--%>


    <%--    <h3>Quận/huyện<span class="note">(*)</span></h3>--%>
    <%--    <form:input path="district" cssStyle="width: 500px" />--%>


    <%--    <h3>Phường/xã<span class="note">(*)</span></h3>--%>
    <%--    <form:input path="ward" cssStyle="width: 500px" />--%>


    <h3>Điện thoại<span class="note">(*)</span></h3>
    <form:input path="phoneNumber" cssStyle="width: 100%"/>


    <h3>Email: </h3>
    <form:input path="email" cssStyle="width: 100%"/>


    <h3><form:button>Gửi tờ khai</form:button></h3>

</form:form>
</body>
</html>
