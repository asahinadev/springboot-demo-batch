package jp.mirageworld.spring.batch.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@SuppressWarnings("serial")
public abstract class AbstractEntity<ID> implements Serializable {

	abstract ID getId();

	@Override
	public final String toString() {
		ReflectionToStringBuilder builder = new ReflectionToStringBuilder(this);

		// クラス変数・定数
		builder.setAppendStatics(false);

		// null フィールド
		builder.setExcludeNullValues(true);

		// 直列化対象外
		builder.setAppendTransients(false);

		// 除外対象のフィールド
		builder.setExcludeFieldNames(excludeFieldNamesParam());

		// 文字列変換
		return builder.build();
	}

	@Override
	public final int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, excludeFieldNamesParam());
	}

	@Override
	public final boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, excludeFieldNamesParam());
	}

	/**
	 * 除外対象のフィールド。
	 * 
	 * @return
	 */
	public String[] excludeFieldNamesParam() {
		return new String[0];
	}
}
