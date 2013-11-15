/*
 * Copyright (C) 2013 たんらる
 */

package fourthline.mabiicco.ui;


import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;

import fourthline.mmlTools.MMLTrack;


public class TrackPropertyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7599129671956571455L;
	private JTextField trackNameField;
	private JSlider panpotSlider;

	MMLTrack track;

	/**
	 * Create the dialog.
	 */
	public TrackPropertyPanel(MMLTrack track) {
		super();
		this.track = track;
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 363, 285);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("トラック名");
		lblNewLabel.setBounds(38, 39, 50, 13);
		add(lblNewLabel);

		trackNameField = new JTextField();
		trackNameField.setBounds(100, 36, 200, 19);
		// TODO: 日本語を入力したとき、再生時にCPU負荷がかかる問題あり.
		trackNameField.setEditable(false);
		add(trackNameField);
		trackNameField.setColumns(10);

		panpotSlider = new JSlider();
		panpotSlider.setSnapToTicks(true);
		panpotSlider.setPaintTicks(true);
		panpotSlider.setValue(64);
		panpotSlider.setMinorTickSpacing(16);
		panpotSlider.setMajorTickSpacing(16);
		panpotSlider.setMaximum(128);
		panpotSlider.setBounds(100, 97, 200, 23);
		add(panpotSlider);

		JLabel label = new JLabel("パンポット");
		label.setBounds(38, 97, 50, 13);
		add(label);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(350, 150);
	}

	private void applyProperty() {
		track.setTrackName( trackNameField.getText() );
		track.setPanpot( panpotSlider.getValue() );
	}

	public void showDialog() {
		trackNameField.setText(track.getTrackName());
		panpotSlider.setValue(track.getPanpot());

		int status = JOptionPane.showConfirmDialog(null, 
				this,
				"トラックプロパティ", 
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (status == JOptionPane.OK_OPTION) {
			applyProperty();
		}
	}
}