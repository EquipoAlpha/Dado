package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Tirada;
import com.ipartek.formacion.repository.mapper.TiradaMapper;


@Repository(value="daoTirada")
public class DAOTiradaImpl implements DAOTirada {

	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Override
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	/* Sentencias SQL */
	private static final String SQL_GET_ALL = "SELECT `id_tirada`, `fecha` FROM `tirada` WHERE `usuario_idusuario`=? ORDER BY `id_tirada` DESC LIMIT 1000;";
	private static final String SQL_INSERT = "INSERT INTO `tirada` (`usuario_idusuario`) VALUES (?);";

	@Override
	public List<Tirada> getAllById(long id_usuario) {
		ArrayList<Tirada> lista = new ArrayList<Tirada>();
		try {

			lista = (ArrayList<Tirada>) this.jdbcTemplate.query(SQL_GET_ALL, new Object[] { id_usuario },
					new TiradaMapper());

		} catch (EmptyResultDataAccessException e) {

			this.logger.warn("No existen recetas todavia");

		} catch (Exception e) {

			this.logger.error(e.getMessage());

		}

		return lista;
	}

	@Override
	public boolean addTirada(final int id_usuario) {
		boolean resul = false;
		try {
			int affectedeRows = -1;
			KeyHolder keyHolder = new GeneratedKeyHolder();

			affectedeRows = this.jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
					ps.setLong(1, id_usuario);
					return ps;
				}
			}, keyHolder);
			if (affectedeRows != -1){
				resul= true;
			}
		} catch (Exception e) {

			this.logger.error(e.getMessage());

		}

		return resul;
	}

}