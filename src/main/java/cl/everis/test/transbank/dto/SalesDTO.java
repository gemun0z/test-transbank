package cl.everis.test.transbank.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalles de las ventas")
public class SalesDTO {
	
	@ApiModelProperty(notes = "Descripción de la venta")
	private String description;
	@ApiModelProperty(notes = "Precio de la venta")
	private String price;
	@ApiModelProperty(notes = "Fecha de la venta (dd-MM-yyyy)")
	private String createDate;
	
	public SalesDTO() {
	}
	public SalesDTO(String description, String price, String createDate) {
		this.description = description;
		this.price = price;
		this.createDate = createDate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "SalesDTO [description=" + description + ", price=" + price + ", createDate=" + createDate + "]";
	}

}
