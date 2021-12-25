# Đồ án Mạng máy Tính
Đề tài 13: Xây chương trình giao diện socket client – server bằng java với giao thức UDP mã hóa và giải mã văn bản với thuật toán mã hóa Ceasar. Chương trình có thể thực hiện các chức năng sau:

Client:

- Cho phép nhập văn bản và khóa để mã hóa văn bản trước khi gửi lên server.

- Trao đổi khóa với server

- Nhận kết quả trả về từ server.

Server:

- Nhận bản mã và khóa sau đó giải mã bản mã để tìm bản rõ.

- Sau khi giải mã xong thì đếm số lượng xuất hiện của các chữ cái trong bản rõ.

- Trả về số lượng xuất hiện của các chữ cái cho client


# Link hướng dẫn

- Client-Server(UDP): https://gpcoder.com/3679-xay-dung-ung-dung-client-server-voi-socket-trong-java/

- Ceasar: https://examples.javacodegeeks.com/caesar-cipher-java-example/

- Trao đổi khóa Diffie-Hellman: https://www.youtube.com/watch?v=Hkjqgl5J7lo
![image](https://user-images.githubusercontent.com/83626285/147381418-4226e208-21ef-4ccf-9b6b-bdcf1b0a2375.png)

 # Công việc
 
 1/ Trao đổi khóa
 - Nguyên lí hoạt đông
 - Căn nguyên thủy(Khái niệm, công thức)
 - Ví dụ: số 296 -> liệt kê các số căn nguyên thủy của 296
 
 2/ Thuật toán mã hóa
 - Nguyên lí hoạt động
 - Yêu cầu của khóa(Lí do khóa chỉ được nằm trong giới hạn đó)
 - Ưu điểm & nhược điểm 
 
 3/ UDP
 - Nguyên lí hoạt động
 - So sách với TCP
 - Ứng dụng của UDP
 - Ưu điểm & nhược điểm
