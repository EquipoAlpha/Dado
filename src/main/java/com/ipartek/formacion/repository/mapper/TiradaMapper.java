package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.domain.Usuario;

public class TiradaMapper implements RowMapper<Tirada> {

	@Override
	public Tirada mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tirada t = new Tirada();
		t.setId_tirada(rs.getLong("id_tirada"));
		t.setFecha_tirada(rs.getTimestamp("fecha"));
		return t;
	}

}
