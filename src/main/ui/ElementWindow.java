package main.ui;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

import main.data.ChemicalElement;
import main.data.Elements;
import main.data.PeriodicTable;

public class ElementWindow extends JFrame {

    private final byte elementIndex;

    public ElementWindow(ChemicalElement element) {

        this.elementIndex = element.getAtomicNumber();

        setTitle(element.getNames().get("de"));
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Hintergrundfarbe aus PeriodicTable holen
        Color elementColor = PeriodicTable.getElementColor(element.getSymbol());
        getContentPane().setBackground(elementColor);

        setLayout(new BorderLayout());

        JLabel symbolLabel = new JLabel(element.getSymbol(), SwingConstants.CENTER);
        symbolLabel.setFont(new Font("Arial", Font.BOLD, 60));
        symbolLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        symbolLabel.setForeground(getContrastColor(elementColor));
        symbolLabel.setOpaque(false);
        add(symbolLabel, BorderLayout.NORTH);

        JPanel detailsPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        detailsPanel.setOpaque(false);
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        addDetail(detailsPanel, "Ordnungszahl:", String.valueOf(element.getAtomicNumber()), 0);
        addDetail(detailsPanel, "Name:", element.getNames().getOrDefault("de", "-"), 1);
        addDetail(detailsPanel, "Atomgewicht:", String.valueOf(element.getAtomicWeight()), 1);
        addDetail(detailsPanel, "Elektronegativität:", String.valueOf(element.getElectronegativity()), 0);
        addDetail(detailsPanel, "Elektronenkonfiguration:", element.getElectronConfiguration(), 1);
        addDetail(detailsPanel, "Schmelzpunkt (°K):", String.valueOf(element.getMeltingPoint()), 0);
        addDetail(detailsPanel, "Siedepunkt (°K):", String.valueOf(element.getBoilingPoint()), 1);
        addDetail(detailsPanel, "Oxidationszahlen:", oxidationArrayToString(IntStream.range(0, element.getOxidationNumbers().length).map(i -> element.getOxidationNumbers()[i]).toArray()), 0);
        addDetail(detailsPanel, "Standardpotential (V):", String.valueOf(element.getStandardPotential()), 1);
        addDetail(detailsPanel, "Gruppe:", element.isExtra().getOrDefault("de", "-"), 0);

        add(detailsPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void addDetail(JPanel panel, String label, String value, int rowIndex) {
        Color bgColor = (rowIndex % 2 == 0) ? new Color(200, 200, 200, 100) : new Color(220, 220, 220, 100);
        JLabel labelComp = new JLabel(label);
        JLabel valueComp = new JLabel(value);

        labelComp.setOpaque(true);
        valueComp.setOpaque(true);
        labelComp.setBackground(bgColor);
        valueComp.setBackground(bgColor);

        labelComp.setForeground(Color.BLACK);
        valueComp.setForeground(Color.BLACK);

        panel.add(labelComp);
        panel.add(valueComp);
    }

    private String oxidationArrayToString(int[] arr) {
        if (arr == null || arr.length == 0) return "-";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length -1) sb.append(", ");
        }
        return sb.toString();
    }

    private Color getContrastColor(Color bg) {
        double luminance = (0.299 * bg.getRed() + 0.587 * bg.getGreen() + 0.114 * bg.getBlue()) / 255;
        return luminance > 0.5 ? Color.BLACK : Color.WHITE;
    }

    public byte getElementNum(){
        return this.elementIndex;
    }

    // Beispielmain zum Testen
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ElementWindow(Elements.getElement("Xenon")));
    }
}
