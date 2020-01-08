package com.demo.data.keys;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemplateDoubleKeys implements Serializable {

	private static final long serialVersionUID = 5701306295931401546L;

	private Long id1;
	private Long id2;

	public boolean equals(Object o) {

		if (this == o)
			return true;

		///
		///
		///
		
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId1(), this.getId2());
	}
}
