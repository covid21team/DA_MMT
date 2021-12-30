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

- Ceasar: https://examples.javacodegeeks.com/caesar-cipher-java-example/ , https://viblo.asia/p/mat-ma-hoc-phan-1-ma-hoa-caesar-RQqKLM0MZ7z

- Trao đổi khóa Diffie-Hellman: https://www.youtube.com/watch?v=Hkjqgl5J7lo
![image](https://user-images.githubusercontent.com/83626285/147381418-4226e208-21ef-4ccf-9b6b-bdcf1b0a2375.png)

 # Công việc
 
 1/ Trao đổi khóa(<b><i><u>Nguyễn Hoàng Trí</u></i></b>)
 - Nguyên lí hoạt đông
 - Căn nguyên thủy(Khái niệm, công thức)
 - Ví dụ: số 353 -> liệt kê các số căn nguyên thủy của 353
 - Tại sao lại phải cần căn nguyên thủy
 - Trao đổi khóa như vậy có thể bị lộ không? Vì sao
 - Ngoài trao đổi số, thì có thể trao đổi kí tự không? Giải thích
 
 2/ Thuật toán mã hóa(<b><i><u>Trương Gia Phú</u></i></b>)
 - Nguyên lí hoạt động
 - Yêu cầu của khóa(Lí do khóa chỉ được nằm trong giới hạn đó)
 - Ưu điểm & nhược điểm 
 - Khóa là kí tự được không? Tại sao
 - Bảo mật như thế nào? Tại sao
 
 3/ UDP(<b><i><u>Hồ Quốc Tuấn</u></i></b>)
 - Nguyên lí hoạt động
 - So sách với TCP
 - Ứng dụng của UDP
 - Ưu điểm & nhược điểm
 - Request bao gồm những gì
 - Tại sao lại cần truyền độ dài
