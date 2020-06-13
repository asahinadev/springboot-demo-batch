package jp.mirageworld.spring.batch.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }),
})
@Entity(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -7270310500627162236L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(nullable = false)
	String username;

	@Column(nullable = false)
	String email;

	@Column(nullable = false)
	String password;

	@Column(nullable = false)
	boolean enabled = false;

	@CreatedDate
	@Column(nullable = false)
	LocalDateTime created;

	@LastModifiedDate
	@Column(nullable = false)
	LocalDateTime updated;

	@ManyToMany(mappedBy = "users")
	List<Role> roles;

	@Override
	public String[] excludeFieldNamesParam() {
		return new String[] {
				"roles"
		};
	}
}
