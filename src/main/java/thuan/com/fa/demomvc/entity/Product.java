package thuan.com.fa.demomvc.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", columnDefinition = "nvarchar(255)", nullable = false)
	@NotBlank(message = "please input name")
	private String name;

	@Range(min = 1, max = 1000, message = "Nhập quantity trong khoảng 1 - 1000")
	private int quantity;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaySanXuat;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioSanXuat;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	public Product() {
		super();
	}

	public Product(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public Product(String name, int quantity, Category category) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.category = category;
	}

	public Product(@NotBlank(message = "please input name") String name,
			@Range(min = 1, max = 1000, message = "Nhập quantity trong khoảng 1 - 1000") int quantity,
			LocalDate ngaySanXuat, LocalTime gioSanXuat, Category category) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.ngaySanXuat = ngaySanXuat;
		this.gioSanXuat = gioSanXuat;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public LocalTime getGioSanXuat() {
		return gioSanXuat;
	}

	public void setGioSanXuat(LocalTime gioSanXuat) {
		this.gioSanXuat = gioSanXuat;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", category=" + category + "]";
	}

}
