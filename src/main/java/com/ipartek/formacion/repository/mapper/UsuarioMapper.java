package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getLong("idusuario"));
		u.setNombre(rs.getString("nombre"));
		u.setFecha_alta(rs.getDate("fecha_alta"));
		u.setFecha_modificacion(rs.getDate("fecha_modificacion"));
		u.setFecha_baja(rs.getDate("fecha_baja"));

		return u;
	}

}
