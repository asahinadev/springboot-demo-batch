package jp.mirageworld.spring.batch.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "roles", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "name" }),
})
@Entity(name = "roles")
public class Role extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -831609121631617496L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(nullable = false)
	String name;

	@ManyToMany
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	List<User> users;

	@Override
	public String[] excludeFieldNamesParam() {
		return new String[] {
				"users"
		};
	}
}
