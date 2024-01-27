package ec.edu.puce.elecciones.formulario;

import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import ec.edu.puce.elecciones.dominio.Prefecto;
import ec.edu.puce.elecciones.dominio.Provincia;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;

public class ReporteGeneral extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel model;

	private List<Prefecto> prefectos;
	private List<Provincia> provincias;
	private String[] provinciasTexto;
	private JButton btnCancelar;
	private JLabel lblNombres;
	private JComboBox comboBox;

	public ReporteGeneral(List<Prefecto> prefectos, List<Provincia> provincias) {
		getContentPane().setBackground(new Color(0, 128, 192));
		this.prefectos = prefectos;
		this.provincias = provincias;
		this.provinciasTexto = new String[this.provincias.size()];
		int i = 0;
		for (Provincia provincia : this.provincias) {
			this.provinciasTexto[i] = provincia.getNombre();
			i++;
		}
		setTitle("REPORTE GENERAL POR PROVINCIA");
		setBounds(100, 100, 600, 309);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 48, 566, 167);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Votos"
			}
		));
		scrollPane.setViewportView(table);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Cambria Math", Font.BOLD, 12));
		btnCancelar.setBackground(new Color(128, 128, 128));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(234, 227, 117, 25);
		getContentPane().add(btnCancelar);
		
		lblNombres = new JLabel("Provincia");
		lblNombres.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblNombres.setBounds(12, 21, 70, 15);
		getContentPane().add(lblNombres);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTabla();
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(this.provinciasTexto));
		comboBox.setBounds(79, 12, 231, 24);
		getContentPane().add(comboBox);

		model = (DefaultTableModel) table.getModel();
		llenarTabla();
		
	}

	
	private void llenarTabla() {
		model.setRowCount(0);
		for (Prefecto prefecto : prefectos) {
			if(prefecto.getProvincia().getNombre() == this.provinciasTexto[this.comboBox.getSelectedIndex()]) {
				Object[] fila = new Object[2];
				fila[0] = prefecto.getNombre();
				fila[1] = prefecto.getVotos();
				model.addRow(fila);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			dispose();
		}
		for (Prefecto prefecto : prefectos) {
			if (prefecto.getNombre() == e.getActionCommand()) {
				prefecto.setVotos(prefecto.getVotos() + 1);
				llenarTabla();
			}
		}
	}
	

	public List<Prefecto> getPrefectos() {
		return prefectos;
	}

	public void setPrefectos(List<Prefecto> prefectos) {
		this.prefectos = prefectos;
	}
	
	
			
		
	}
	

