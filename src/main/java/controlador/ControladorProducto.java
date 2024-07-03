package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassProductoImp;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassProductoImp crud = new ClassProductoImp();
		TblProductocl3 producto = new TblProductocl3();
		
		String accion = request.getParameter("accion");
		if(accion!=null){
			switch(accion){
			case "Modificar":
				int codigo = Integer.parseInt(request.getParameter("codigo"));
				producto.setIdproductocl3(codigo);
				TblProductocl3 buscarcod = crud.BuscarProducto(producto);
				
				request.setAttribute("codigo", buscarcod.getIdproductocl3());
				request.setAttribute("nombre", buscarcod.getNombrecl3());
				request.setAttribute("precioventa", buscarcod.getPrecioventacl3());
				request.setAttribute("preciocomp", buscarcod.getPreciocompcl3());
				request.setAttribute("estado", buscarcod.getEstadocl3());
				request.setAttribute("descrip", buscarcod.getDescripcl3());
				request.getRequestDispatcher("/FormActualizarProducto.jsp").forward(request, response);
				break;
				
			case "Eliminar":
				int codeeliminar = Integer.parseInt(request.getParameter("codigo"));
				producto.setIdproductocl3(codeeliminar);
				crud.EliminarProducto(producto);
				List<TblProductocl3> listado = crud.ListadoProducto();
				request.setAttribute("listadoproductos", listado);
				request.getRequestDispatcher("/FormRegistrarProducto.jsp").forward(request, response);
				break;
				
			case "Listar":
				List<TblProductocl3> listadoProducto=crud.ListadoProducto();
				request.setAttribute("listadoproductos", listadoProducto);
				request.getRequestDispatcher("/FormRegistrarProducto.jsp").forward(request, response);
				break;
			}
			
				
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		double precioventa = Double.parseDouble(request.getParameter("precioventa"));
		double preciocomp = Double.parseDouble(request.getParameter("preciocomp"));
		String estado = request.getParameter("estado");
		String descrip = request.getParameter("descrip");
		
		List<TblProductocl3> listadoproducto = null;
		
		TblProductocl3 producto = new TblProductocl3();
		
		ClassProductoImp crud = new ClassProductoImp();
		
		producto.setNombrecl3(nombre);
		producto.setPrecioventacl3(precioventa);
		producto.setPreciocompcl3(preciocomp);
		producto.setEstadocl3(estado);
		producto.setDescripcl3(descrip);
		
		
		if(codigo != null){
			int cod = Integer.parseInt(codigo);
			producto.setIdproductocl3(cod);
			crud.ActualizarProducto(producto);
			listadoproducto = crud.ListadoProducto();
		}else{
			crud.RegistrarProducto(producto);
			listadoproducto = crud.ListadoProducto();
		}
		
	
	
		request.setAttribute("listadoproductos", listadoproducto);
		request.getRequestDispatcher("/FormRegistrarProducto.jsp").forward(request, response);
	}

}
