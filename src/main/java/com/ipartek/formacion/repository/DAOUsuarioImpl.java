package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.repository.mapper.UsuarioMapper;

/**
 * 
 * @author Curso
 *
 */
@Repository(value = "daoUsuario")
public class DAOUsuarioImpl implements DAOUsuario {

	private final Log logger = LogFactory.getLog(getClass());
	@Autowired()
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired()
	@Override()
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	/* Sentencias SQL */
	private static final String SQL_GET_ALL = "SELECT `idusuario`, `nombre`, `fecha_alta`, `fecha_modificacion`,`fecha_baja` FROM `usuario` WHERE fecha_baja IS NULL ORDER BY `idusuario` DESC LIMIT 1000;";
	private static final String SQL_GET_ALL_DELETED = "SELECT `idusuario`, `nombre`, `fecha_alta`, `fecha_modificacion`,`fecha_baja` FROM `usuario` WHERE fecha_baja IS NOT NULL ORDER BY `idusuario` DESC LIMIT 1000;";

	private static final String SQL_GET_RANKING="SELECT COUNT(tirada.usuario_idusuario) As tirada, usuario.idusuario, usuario.nombre,usuario.fecha_alta,usuario.fecha_modificacion,usuario.fecha_baja FROM dado.tirada INNER JOIN dado.usuario ON "
			+ "usuario.idusuario=tirada.usuario_idusuario WHERE usuario.fecha_baja IS NULL group by usuario_idusuario ORDER BY `tirada` DESC LIMIT 1000;";
	private static final String SQL_GET_BY_ID = "SELECT `idusuario`, `nombre`, `fecha_alta`, `fecha_modificacion`,`fecha_baja` FROM `usuario` WHERE `idusuario` = ?";
	private static final String SQL_INSERT = "INSERT INTO `usuario` (`nombre`) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE `usuario` SET `nombre`= ? ,`fecha_modificacion`=?  WHERE `idusuario`= ?;";
	private static final String SQL_DELETE = "UPDATE `usuario` SET `fecha_baja`=?  WHERE `idusuario`= ?;";

	private static final String SQL_REACTIVATE = "UPDATE `usuario` SET `fecha_baja`=?  WHERE `idusuario`= ?;";

	@Override()
	public List<Usuario> getAll() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {

			lista = (ArrayList<Usuario>) this.jdbcTemplate.query(SQL_GET_ALL, new UsuarioMapper());

		} catch (EmptyResultDataAccessException e) {

			this.logger.warn("No existen recetas todavia");

		} catch (Exception e) {

			this.logger.error(e.getMessage());

		}

		return lista;
	}

	@Override()
	public Usuario getById(long id) {
		Usuario u = new Usuario();

		try {

			u = this.jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[] { id }, new UsuarioMapper());

		} catch (EmptyResultDataAccessException e) {

			this.logger.warn("No existen recetas todavia");

		} catch (Exception e) {

			this.logger.error(e.getMessage());

		}

		return u;
	}

	@Override()
	public boolean insert(final Usuario u) {
		this.logger.trace("insert " + u);
		boolean resul = false;

		try {
			int affectedeRows = -1;
			KeyHolder keyHolder = new GeneratedKeyHolder();

			affectedeRows = this.jdbcTemplate.update(new PreparedStatementCreator() {

				@Override()
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, u.getNombre());
					return ps;
				}
			}, keyHolder);

			if (affectedeRows == 1) {
				u.setId(keyHolder.getKey().longValue());
				resul = true;
			}
		} catch (Exception e) {

			this.logger.error(e.getMessage());

		}

		return resul;
	}

	@Override()
	public boolean update(Usuario u) {
		this.logger.trace("update " + u);
		boolean resul = false;
		int affectedRows = -1;
		try {
			Object[] argumentos = {u.getNombre(), new Timestamp(System.currentTimeMillis()), u.getId()};
			affectedRows = this.jdbcTemplate.update(SQL_UPDATE, argumentos);
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}

		return resul;
	}

	@Override()
	public boolean delete(long id) {
		boolean resul = false;
		int affectedRows = -1;
		try {
			Object[] argumentos = {new Timestamp(System.currentTimeMillis()),id};
			affectedRows = this.jdbcTemplate.update(SQL_DELETE, argumentos);
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}

		return resul;
	}

	@Override()
	public List<Usuario> getAllDeleted() {
		// TODO Auto-generated method stub
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {

			lista = (ArrayList<Usuario>) this.jdbcTemplate.query(SQL_GET_ALL_DELETED, new UsuarioMapper());

		} catch (EmptyResultDataAccessException e) {

			this.logger.warn("No existen recetas todavia");

		} catch (Exception e) {

			this.logger.error(e.getMessage());

		}

		return lista;
	}

	@Override()
	public boolean activate(long idUsuario) {
		// TODO Auto-generated method stub
		boolean resul = false;
		int affectedRows = -1;
		try {
			Object[] argumentos = {null,idUsuario};
			affectedRows = this.jdbcTemplate.update(SQL_REACTIVATE, argumentos);
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}

		return resul;
	}

	@Override()
	public ArrayList<Usuario> getRanking() {
		// TODO Auto-generated method stub
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {

			lista = (ArrayList<Usuario>) this.jdbcTemplate.query(SQL_GET_RANKING, new UsuarioMapper());

		} catch (EmptyResultDataAccessException e) {

			this.logger.warn("No existen recetas todavia");

		} catch (Exception e) {

			this.logger.error(e.getMessage());

		}

		return lista;
	}

}
