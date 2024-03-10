package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Book;





public class BookUtil {
	//Đọc danh sách 
			public static List<Book> queryBook(Connection conn) throws SQLException{
				String sql = "Select a.BookId, a.Title, a.Author,a.Release,a.Price,a.Picture,a.PublisherId,a.CategoryId from Book a";
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				List<Book> list = new ArrayList<Book>();
				
				while (rs.next()) {
					String bookid = rs.getString("BookId");
					String title = rs.getString("Title");
					String author = rs.getString("Author");
					int release = rs.getInt("Release");
					float price = rs.getFloat("Price");
					String picture = rs.getString("picture");
					int publisherid = rs.getInt("PublisherId");
					int categoryid =rs.getInt("CategoryId");
					Book book = new Book();
					book.setBookId(bookid);
					book.setTitle(title);
					book.setAuthor(author);
					book.setRelease(release);
					book.setPrice(price);
					book.setPicture(picture);
					book.setPublisherId(publisherid);
					book.setCategoryId(categoryid);
					list.add(book);
				}
				return list;
			}
			// Them san pham moi
			public static void addBook(Connection conn, Book newBook) throws SQLException {
			    String sql = "INSERT INTO Book (BookId, Title, Author, Release, Price,Picture,PublisherId,CategoryId) VALUES (?, ?, ?, ?, ?,?,?,?)";
			    try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			        pstm.setString(1, newBook.getBookId());
			        pstm.setString(2, newBook.getTitle());
			        pstm.setString(3, newBook.getAuthor());
			        pstm.setInt(4, newBook.getRelease());
			        pstm.setFloat(5, newBook.getPrice());
			        pstm.setString(6, newBook.getPicture());
			        pstm.setInt(7, newBook.getPublisherId());
			        pstm.setInt(8, newBook.getCategoryId());

			        pstm.executeUpdate();
			        
			    }
			    
			}
			
			// Sửa thông tin của một sản phẩm
		    public static void updateBook(Connection conn, Book updatedBook) throws SQLException {
		        String sql = "UPDATE Book SET Title = ?, Author = ?, Release = ?, Price = ?,Picture = ?,PublisherId = ?,CategoryId = ? WHERE BookId = ?";
		        
		        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
		            pstm.setString(8, updatedBook.getBookId());
		            pstm.setString(1, updatedBook.getTitle());
			        pstm.setString(2, updatedBook.getAuthor());
			        pstm.setInt(3, updatedBook.getRelease());
			        pstm.setFloat(4, updatedBook.getPrice());
			        pstm.setString(5, updatedBook.getPicture());
			        pstm.setInt(6, updatedBook.getPublisherId());
			        pstm.setInt(7, updatedBook.getCategoryId());

		            pstm.executeUpdate();
		        }
		    }
		 // Xóa một sản phẩm dựa trên mã sản phẩm
		    public static void deleteBook(Connection conn, String maSach) throws SQLException {
		        String sql = "DELETE FROM Book WHERE BookId = ?";
		        
		        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
		            pstm.setString(1, maSach);

		            pstm.executeUpdate();
		        }
		    }
		    public static Book findBookByCode(Connection conn, String code) throws SQLException {
		        String sql = "SELECT * FROM Book WHERE BookId = ?";
		        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
		            pstm.setString(1, code);
		            try (ResultSet rs = pstm.executeQuery()) {
		                if (rs.next()) {
		                	String bookid = rs.getString("BookId");
							String title = rs.getString("Title");
							String author = rs.getString("Author");
							int release = rs.getInt("Release");
							float price = rs.getFloat("Price");
							String picture = rs.getString("picture");
							int publisherid = rs.getInt("PublisherId");
							int categoryid =rs.getInt("CategoryId");

		                    return new Book(bookid, title,author, release,price,picture,publisherid,publisherid);
		                }
		            }
		        }
		        return null; // Trả về null nếu không tìm thấy sản phẩm
		    }  
}
