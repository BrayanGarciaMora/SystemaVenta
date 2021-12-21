package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ClienteDAO {
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	int r;

	public List listarCliente() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> listaCliente = new ArrayList<>();

		try {

			con = cn.conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(1));
				cliente.setDni(rs.getString(2));
				cliente.setNombre(rs.getString(3));
				cliente.setDireccion(rs.getString(4));
				cliente.setEstado(rs.getString(5));

				listaCliente.add(cliente);

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se ha podido Establecer la conexion");
		}
		return listaCliente;
	}
	// Metodo Agregar-------------------------------------------------------

	public int agregar(Cliente cliente) {

		// Consulta sql

		String sql = "INSERT INTO cliente (Dni, Nombres, Direccion, Estado) VALUES (?,?,?,?)";

		try {
			// pedir la conexion a la base de datos
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			// Prepara la consulta
			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setString(4, cliente.getEstado());

			// Ejecutar la consulta

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;
	}
}
