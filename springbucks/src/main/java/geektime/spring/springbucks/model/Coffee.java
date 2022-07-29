package geektime.spring.springbucks.model;

import lombok.Builder;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_COFFEE")
@Builder
@ToString(callSuper = true)
public class Coffee extends BaseEntity implements Serializable {

	private String name;

	@Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount", parameters = {
			@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY") })
	private Money price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

}
