package com.demo.api.dto;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



/**
 * A general container with only one parameter, for row data without a top-level parent.
 * <pre>
 * -----------------------------------------------------------------------------
 * clone and modify class name, naming rule is [USAGE OF DESCRIPTION] + Data
 * Ex: TemplateData
 * 
 * If usage is row data for some like TemplateData, naming rule is [USAGE OF DESCRIPTION] + RowData
 * Ex: TemplateRowData
 * 
 * when TemplateData includes the row data, the field name recommended naming to "rows".
 * Ex: 
 *  public class TemplateData {
 *  final private String _DTO = this.getClass().getSimpleName();
 *  private List&lt;TemplateRowData&gt; rows;
 *  }        
 *  -----------------------------------------------------------------------------
 *  finally, don't forget to remove here.
 *  -----------------------------------------------------------------------------
 * </pre>
 * @author Allen, Chiang
 * @apiNote 
 */
@Getter
@Setter
@ToString
public class TemplateData {
	// DTO signature
	final private String _DTO = this.getClass().getSimpleName();
	// ----------------------parameters------------------------//
	private Collection<? extends Object> rows;
	private Map<?, ?> maps;
	// ----------------------constructor------------------------//
	public TemplateData() {
		
	}
	public TemplateData(Collection<? extends Object> rows) {
		this.rows = rows;
	}
	public TemplateData(Map<?,?> maps) {
		this.maps = maps;
	}
}
