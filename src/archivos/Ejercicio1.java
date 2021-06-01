package archivos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercicio1 extends JFrame {

	private JPanel contentPane;
	protected JPanel panel;
	private final JScrollPane scrollPane = new JScrollPane();
	protected JTable table;
	protected JTextField txtNro;
	protected JTextField txtNombre;
	protected JTextField txtDni;
	protected JLabel nro;
	protected JLabel lblNombre;
	protected JLabel lblDni;
	protected JButton btnLeer;
	protected JButton btnOut;
	protected JButton btnAgregar;
	protected JButton btnModificar;
	protected JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	HashSet <Elemento> listaElementos = new HashSet<Elemento>();
	protected JLabel lbl1;

	/**
	 * Create the frame.
	 */
	public Ejercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 462);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.panel = new JPanel();
		this.panel.setBounds(0, 0, 644, 228);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);
		
		this.txtNro = new JTextField();
		this.txtNro.setBounds(139, 39, 120, 20);
		this.panel.add(this.txtNro);
		this.txtNro.setColumns(10);
		
		this.txtNombre = new JTextField();
		this.txtNombre.setColumns(10);
		this.txtNombre.setBounds(139, 82, 234, 20);
		this.panel.add(this.txtNombre);
		
		this.txtDni = new JTextField();
		this.txtDni.setColumns(10);
		this.txtDni.setBounds(139, 129, 120, 20);
		this.panel.add(this.txtDni);
		
		this.nro = new JLabel("nro");
		this.nro.setBounds(44, 42, 46, 14);
		this.panel.add(this.nro);
		
		this.lblNombre = new JLabel("nombre");
		this.lblNombre.setBounds(44, 85, 46, 14);
		this.panel.add(this.lblNombre);
		
		this.lblDni = new JLabel("dni");
		this.lblDni.setBounds(44, 135, 46, 14);
		this.panel.add(this.lblDni);
		
		this.btnLeer = new JButton("leer");
		this.btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String Txtentrada = "D:\\Martin\\Entrada.txt";
				String[] linea;
				
				metodoRLinea(listaElementos, Txtentrada);
				
				
				
			}
		});
		this.btnLeer.setBounds(288, 36, 89, 23);
		this.panel.add(this.btnLeer);
		
		this.btnOut = new JButton("out");
		this.btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String Txtsalida = "D:\\Martin\\salida2.txt";
				
				
				File file = new File(Txtsalida);
				// Si el archivo no existe es creado
				if (!file.exists()) {
				JOptionPane.showMessageDialog(null, "archivo no existe");
				
				}
				else {
				
				metodoWLinea(listaElementos, Txtsalida); // writer
				}
				
				
				
				
			}
		});
		this.btnOut.setBounds(386, 36, 89, 23);
		this.panel.add(this.btnOut);
		
		this.btnAgregar = new JButton("agregar");
		this.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				int nro = Integer.parseInt( txtNro.getText());
				String nombre = txtNombre.getText();
				String dni = txtDni.getText();
				
				Elemento elemento = new Elemento(nro,nombre,dni);
				listaElementos.add(elemento);
				
				getTable();
				
				}
				catch(Exception er) {}
				
				
			}
		});
		this.btnAgregar.setBounds(485, 36, 89, 23);
		this.panel.add(this.btnAgregar);
		
		this.btnModificar = new JButton("modificar");
		this.btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					
					int nro = Integer.parseInt( txtNro.getText());
					String nombre = txtNombre.getText();
					String dni = txtDni.getText();
					for(Elemento el : listaElementos) {
						
						if(el.getNro().equals(nro)) {
							
							
							el.setNombre(nombre);
							el.setDni(dni);
							
							
						}
						
						
						
					}			
				
					
					getTable();
					
					}
					catch(Exception er) {}
			
			 
			 
				
				
				
			}
		});
		this.btnModificar.setBounds(485, 81, 89, 23);
		this.panel.add(this.btnModificar);
		
		this.btnSalir = new JButton("Salir");
		this.btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		this.btnSalir.setBounds(485, 128, 89, 23);
		this.panel.add(this.btnSalir);
		
		this.lbl1 = new JLabel("New label");
		this.lbl1.setBounds(44, 184, 46, 14);
		this.panel.add(this.lbl1);
		scrollPane.setBounds(0, 229, 644, 194);
		this.contentPane.add(scrollPane);
		
		this.table = new JTable();
		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				Integer pos = table.getSelectedRow();
				lbl1.setText(pos.toString());
				
				txtNro.setText(table.getValueAt(pos, 0).toString());
				txtNombre.setText(table.getValueAt(pos, 1).toString());
				txtDni.setText(table.getValueAt (pos, 2).toString());
				
				
			}
		});
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"nro", "nombre", "Dni"
			}
		));
		scrollPane.setViewportView(this.table);
		
		
		listaElementos.add(new Elemento(1000, "Martin Estrada", "32831554"));
		getTable();
		
	}
	
	
	
	public void getTable() {
		
		int col =0;
		Elemento el;
		String [][] ArrayElementos = new String [listaElementos.size()][3];
		
		for(Iterator<Elemento> it = listaElementos.iterator(); it.hasNext();) {
					
					el = (Elemento) it.next();	
			
					ArrayElementos[col][0] = el.getNro().toString();
					ArrayElementos[col][1] = el.getNombre();
					ArrayElementos[col][2] =el.getDni();
					++col;
		}
		
				
		
		this.table.setModel(new DefaultTableModel(
				ArrayElementos,
				new String[] {
					"nro", "nombre", "Dni"
				}
			));
		
		
		
		
	}
	
	private void metodoRLinea(HashSet<Elemento> hs1, String NombreTxtentrada) {
			int reg = 0;
			try {
			FileReader entrada = new FileReader(NombreTxtentrada);
			BufferedReader miBuffer = new BufferedReader(entrada); // creo el buffer para leer
			String salida = "";
			String linea = "";
			while (linea != null) {
			linea = miBuffer.readLine();
			// leo una linea
			if (linea != null) {
			salida +=  linea;
			String[]campos = linea.split(";");
			int nro = Integer.parseInt(campos[0]);
			
			hs1.add(new Elemento(nro, campos[1], campos[2]));
			++reg;
			}}
			JOptionPane.showMessageDialog(null, salida);
			
			getTable();
			
			
			
			entrada.close(); // close the stream
			miBuffer.close(); // close the buffer
			
			
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			}
	
	
	private  void metodoWLinea(HashSet<Elemento> listaElementos, String
			nombreSalida) {
			
		try {
			File file = new File(nombreSalida);
			
			if(!file.exists()) {
				
				file.createNewFile();			
				
			}
			FileWriter salida = new FileWriter(nombreSalida);
			BufferedWriter bw = new BufferedWriter(salida);
			
			for(Iterator<Elemento> it = listaElementos.iterator(); it.hasNext();) {
				
				Elemento el = (Elemento) it.next();
				
				bw.write(el.getNro()+";"+el.getNombre()+";"+el.getDni());
				bw.newLine();
				bw.flush();
				
				
			}
			bw.close();		
		}
		catch(Exception er) {}
		
		
		
	}
}
