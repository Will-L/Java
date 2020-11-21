package CDArchiveProject;

import sorting.BubbleSort;
import sorting.Insertion;
import sorting.Selection;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ArchiveConsole {
    JFrame window;
    List<CDRecord> records;

    CDRecordTableModel tableData;

    JTextField titleText;
    JTextField authorText;
    JTextField sectionText;
    JTextField xText;
    JTextField yText;
    JTextField barcodeText;
    JTextArea descriptionText;
    JCheckBox onLoan;

    boolean isUpdate;

    int selectedIndex;

    JTable cdRecordTable;


    public ArchiveConsole() {
        records = RecordStorage.loadRecordList("records.data");

        window = new JFrame("Archive Management Console");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.getContentPane().setLayout(new GridBagLayout());

        window.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


        createUI();

        window.pack();
        window.setMinimumSize(new Dimension(700,400));
        window.setSize(new Dimension(700, 400));
        window.setVisible(true);
    }

    private void createUI() {
        JLabel searchLabel = new JLabel("Search String");
        addComponent(
                window.getContentPane(), searchLabel, GridBagConstraints.BOTH,
                0, 0, 1, 1, 0.0f, 0.0f
        );

        JTextField searchText = new JTextField();
        addComponent(
                window.getContentPane(), searchText, GridBagConstraints.BOTH,
                1, 0, 1, 1, 40.0f, 0.0f
        );

        JButton searchButton = new JButton("Search Dat");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                for (CDRecord record: records) {
                    if (record.getTitle().equals(searchText.getText())) {
                        cdRecordTable.clearSelection();
                        cdRecordTable.addRowSelectionInterval(i, i);
                    }
                    i++;
                }
            }
        });

        searchButton.setBackground(Color.cyan);
        addComponent(
                window.getContentPane(), searchButton, GridBagConstraints.BOTH,
                2, 0, 1, 1, 20.0f, 0.0f
        );

        JPanel archiveListPanel = createArchiveListPanel();
        addComponent(
                window.getContentPane(), archiveListPanel,
                GridBagConstraints.BOTH, 0, 1,
                3, 1, 70.0f, 40.0f
        );

        JPanel processLogPanel = createProcessLogPanel();
        addComponent(
                window.getContentPane(), processLogPanel,
                GridBagConstraints.BOTH, 0, 2,
                3, 1, 70.0f, 40.0f
        );

        JPanel recordPanel = createRecordPanel();
        addComponent(
                window.getContentPane(), recordPanel,
                GridBagConstraints.BOTH, 3, 0,
                1, 2, 30.0f, 40.0f
        );

        JPanel actionRequestPanel = createActionRequestPanel();
        addComponent(
                window.getContentPane(), actionRequestPanel,
                GridBagConstraints.BOTH, 3,2,
                1,1, 30.0f, 40.0f
        );
    }

    private JPanel createArchiveListPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Archive CD's");
        addComponent(
                panel, titleLabel, GridBagConstraints.BOTH,
                0, 0, 4, 1, 100.0f,
                0.0f
        );

        cdRecordTable = new JTable();
        cdRecordTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedIndex = cdRecordTable.getSelectedRow();
                CDRecord selectedRecord = records.get(selectedIndex);

                titleText.setText(selectedRecord.getTitle());
                authorText.setText(selectedRecord.getAuthor());
                sectionText.setText(selectedRecord.getSection());
                xText.setText(Integer.toString(selectedRecord.getX()));
                yText.setText(Integer.toString(selectedRecord.getY()));
                barcodeText.setText(Integer.toString(selectedRecord.getBarcode()));
                descriptionText.setText(selectedRecord.getDescription());
                onLoan.setSelected(selectedRecord.onLoan);

                isUpdate = true;

                System.out.println(selectedRecord);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.tableData = new CDRecordTableModel(records);
        cdRecordTable.setModel(tableData);

        cdRecordTable.setFillsViewportHeight(true);
        JScrollPane cdRecordTableScrollPane = new JScrollPane(cdRecordTable);
        addComponent(
                panel, cdRecordTableScrollPane,
                GridBagConstraints.BOTH, 0 ,1,
                4, 1, 100.0f, 10.0f
        );

        JLabel sortLabel = new JLabel("Sort");
        addComponent(
                panel, sortLabel, GridBagConstraints.BOTH, 0, 2,
                1, 1, 0.0f, 0.0f
        );

        JButton sortByTitleButton = new JButton("By title");
        sortByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BubbleSort.sort(records);
                tableData.fireTableDataChanged();
            }
        });
        addComponent(
                panel, sortByTitleButton, GridBagConstraints.VERTICAL,
                1,2, 1, 1, 0.0f, 0.0f
        );

        JButton sortByAuthorButton = new JButton("By Author");
        sortByAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Selection.sort(records);
                tableData.fireTableDataChanged();
            }
        });
        addComponent(
                panel, sortByAuthorButton, GridBagConstraints.VERTICAL,
                2,2, 1, 1, 0.0f, 0.0f
        );

        JButton sortByBarcodeButton = new JButton("By Barcode");
        sortByBarcodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Insertion.sort(records);
                tableData.fireTableDataChanged();
            }
        });
        addComponent(
                panel, sortByBarcodeButton, GridBagConstraints.VERTICAL,
                3,2, 1, 1, 0.0f, 0.0f
        );


        return panel;
    }

    private  JPanel createProcessLogPanel() {
        JPanel panel = new JPanel();
        panel.setLayout((new GridBagLayout()));

        JLabel processLogLabel = new JLabel("Process Log");
        addComponent(
                panel, processLogLabel, GridBagConstraints.HORIZONTAL,
                0, 0, 1, 1, 0.0f,
                0.0f,
                new Insets(0, 0, 0, 0), GridBagConstraints.EAST
        );

        JButton processLog = new JButton("Process Log");
        addComponent(
                panel, processLog, GridBagConstraints.HORIZONTAL,
                3,0, 1, 1, 0.0f, 0.0f
        );

        JTextArea processLogText = new JTextArea();

        addComponent(
                panel, processLogText, GridBagConstraints.BOTH,
                0, 2, 0, 5, 10.0f, 10.0f

        );

        JLabel displayBinaryTreeLabel = new JLabel("Display Binary Tree:");
        addComponent(
                panel, displayBinaryTreeLabel, GridBagConstraints.HORIZONTAL,
                0, 10, 1, 1, 0.0f,
                10.0f
        );

        JButton preOrderButton = new JButton("Pre-Order");
        addComponent(
                panel, preOrderButton, GridBagConstraints.HORIZONTAL,
                1,10, 1, 1, 0.0f, 0.0f
        );

        JButton inOrderButton = new JButton("In-Order");
        addComponent(
                panel, inOrderButton, GridBagConstraints.HORIZONTAL,
                2,10, 1, 1, 0.0f, 0.0f
        );

        JButton postOrderButton = new JButton("Post-Order");
        addComponent(
                panel, postOrderButton, GridBagConstraints.HORIZONTAL,
                3,10, 1, 1, 10.0f, 0.0f
        );

        JLabel hashMapLabel = new JLabel("HashMap: ");
        addComponent(
                panel, hashMapLabel, GridBagConstraints.HORIZONTAL,
                0, 11, 1, 1, 0.0f,
                10.0f
        );

        JButton saveButton = new JButton("Save");
        addComponent(
                panel, saveButton, GridBagConstraints.HORIZONTAL,
                1,11, 1, 1, 0.0f, 0.0f
        );

        JButton displayButton = new JButton("Display");
        addComponent(
                panel, displayButton, GridBagConstraints.HORIZONTAL,
                2,11, 1, 1, 0.0f, 0.0f
        );

        return panel;
    }

    private JPanel createRecordPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Title: ");
        addComponent(
                panel, titleLabel, GridBagConstraints.BOTH,
                0, 0, 2, 1, 0.0f,
                30.0f,
                new Insets(0, 0,10, 0), GridBagConstraints.SOUTH
        );

        titleText = new JTextField();
        addComponent(
                panel, titleText, GridBagConstraints.BOTH,
                1, 0, 2, 1, 0.0f, 0.0f
        );

        JTextField idTitleText = new JTextField();
        idTitleText.setEnabled(false);
        addComponent(
                panel, idTitleText, GridBagConstraints.BOTH,
                2, 0, 2, 1, 0.0f, 0.0f
        );

        JLabel authorLabel = new JLabel("Author: ");
        addComponent(
                panel, authorLabel, GridBagConstraints.BOTH,
                0, 2, 1, 1, 0.0f,
                30.0f,
                new Insets(10, 0, 0, 0), GridBagConstraints.NORTH
        );

        authorText = new JTextField();
        addComponent(
                panel, authorText, GridBagConstraints.BOTH,
                1, 2, 1, 1, 40.0f, 0.0f
        );

        JLabel sectionLabel = new JLabel("Section: ");
        addComponent(
                panel, sectionLabel, GridBagConstraints.BOTH,
                0, 4, 1, 1, 0.0f,
                30.0f
        );

        sectionText = new JTextField();
        addComponent(
                panel, sectionText, GridBagConstraints.BOTH,
                1, 4, 1, 1, 40.0f, 0.0f
        );

        JLabel xLabel = new JLabel("X: ");
        addComponent(
                panel, xLabel, GridBagConstraints.BOTH,
                0, 6, 1, 1, 0.0f,
                30.0f
        );

        xText = new JTextField();
        addComponent(
                panel, xText, GridBagConstraints.BOTH,
                1, 6, 1, 1, 40.0f, 0.0f
        );

        JLabel yLabel = new JLabel("Y: ");
        addComponent(
                panel, yLabel, GridBagConstraints.BOTH,
                0, 8, 1, 1, 0.0f,
                30.0f
        );

        yText = new JTextField();
        addComponent(
                panel, yText, GridBagConstraints.BOTH,
                1, 8, 1, 1, 40.0f, 0.0f
        );

        JLabel barcodeLabel = new JLabel("Barcode: ");
        addComponent(
                panel, barcodeLabel, GridBagConstraints.BOTH,
                0, 10, 1, 1, 0.0f,
                20.0f
        );

        barcodeText = new JTextField();
        addComponent(
                panel, barcodeText, GridBagConstraints.BOTH,
                1, 10, 1, 1, 40.0f, 0.0f
        );

        JLabel descriptionLabel = new JLabel("Description: ");
        addComponent(
                panel, descriptionLabel, GridBagConstraints.BOTH,
                0, 12, 1, 1, 0.0f,
                20.0f
        );

        descriptionText = new JTextArea();

        addComponent(
                panel, descriptionText, GridBagConstraints.BOTH,
                1, 12, 3, 1, 40.0f, 0.0f

        );

        JLabel onLoanLabel = new JLabel("On Loan: ");
        addComponent(
                panel, onLoanLabel, GridBagConstraints.BOTH,
                0, 15, 1, 1, 0.0f, 20.0f
        );

        onLoan = new JCheckBox();
        addComponent(
                panel, onLoan, GridBagConstraints.BOTH,
                1, 15, 1, 1, 0.0f, 20.0f
        );

        JButton newItemButton = new JButton("New Item");
        newItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titleText.setText("");
                authorText.setText("");
                sectionText.setText("");
                xText.setText("");
                yText.setText("");
                barcodeText.setText("");
                descriptionText.setText("");

                isUpdate = false;

            }
        });
        addComponent(
                panel, newItemButton, GridBagConstraints.VERTICAL,
                0,17, 1, 1, 0.0f, 0.0f
        );

        JButton saveUpdateButton = new JButton("Save / Update");
        saveUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CDRecord record = new CDRecord(
                        titleText.getText(),
                        authorText.getText(),
                        sectionText.getText(),
                        Integer.parseInt(xText.getText()),
                        Integer.parseInt(yText.getText()),
                        Integer.parseInt(barcodeText.getText()),
                        descriptionText.getText(),
                        onLoan.isSelected()


                );

                if (isUpdate) {
                    records.set(selectedIndex, record);
                    tableData.fireTableDataChanged();
                    return;
                }

                records.add(record);
                tableData.fireTableDataChanged();
            }
        });
        addComponent(
                panel, saveUpdateButton, GridBagConstraints.VERTICAL,
                3,17, 1, 1, 0.0f, 0.0f
        );

        return panel;
    }

    private JPanel createActionRequestPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel actionRequestLabel = new JLabel("Automation Action Request For The Item Above:");
        addComponent(
                panel, actionRequestLabel, GridBagConstraints.BOTH,
                1, 12, 1, 1, 0.0f,
                0.0f
        );

        JButton retrieveButton = new JButton("Retrieve");
        addComponent(
                panel, retrieveButton, GridBagConstraints.HORIZONTAL,
                0,17, 1, 1, 10.0f, 10.0f
        );

        JButton removeButton = new JButton("Remove");
        addComponent(
                panel, removeButton, GridBagConstraints.HORIZONTAL,
                1,17, 1, 1, 10.0f, 10.0f
        );

        JButton returnButton = new JButton("Return");
        addComponent(
                panel, returnButton, GridBagConstraints.HORIZONTAL,
                0,20, 1, 1, 10.0f, 10.0f
        );

        JButton addToCollectionButton = new JButton("Add to Collection");
        addComponent(
                panel, addToCollectionButton, GridBagConstraints.HORIZONTAL,
                1,20, 1, 1, 10.0f, 10.0f
        );

        JLabel sortLabel = new JLabel("Sort Section:");
        addComponent(
                panel, sortLabel, GridBagConstraints.BOTH,
                0, 25, 1, 1, 0.0f,
                0.0f
        );

        JTextField descriptionText = new JTextField();
        addComponent(
                panel, descriptionText, GridBagConstraints.HORIZONTAL,
                1, 25, 1, 1, 0.0f, 10.0f
        );

        JButton randomCollectionSortButton = new JButton("Random Collection Sort");
        addComponent(
                panel, randomCollectionSortButton, GridBagConstraints.HORIZONTAL,
                1,30, 1, 1, 10.0f, 10.0f
        );

        JButton mostlySortButton = new JButton("Mostly Sorted Sort");
        addComponent(
                panel, mostlySortButton, GridBagConstraints.HORIZONTAL,
                1,31, 1, 1, 10.0f, 10.0f
        );

        JButton reverseOrderSortButton = new JButton("Reverse Sort");
        addComponent(
                panel, reverseOrderSortButton, GridBagConstraints.HORIZONTAL,
                1,32, 1, 1, 10.0f, 10.0f
        );

        JButton exitButton = new JButton("EXIT this Piece!");
        addComponent(
                panel, exitButton, GridBagConstraints.HORIZONTAL,
                0,45, 2, 2, 0.0f, 0.0f


        );

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordStorage.saveRecordList("records.data", records);
                System.exit(0);
            }
        });

        return panel;
    }

    private <C extends  Component> void addComponent(
            Container contentPane, C Component,
            int fill, int gridX, int gridY, int gridWidth,
            int gridHeight, float weightX, float weightY
    ) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = fill;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.gridwidth = gridWidth;
        constraints.gridheight = gridHeight;
        constraints.weightx = weightX;
        constraints.weighty = weightY;

        contentPane.add(Component, constraints);

    }

    private <C extends  Component> void addComponent(
            Container contentPane, C Component,
            int fill, int gridX, int gridY, int gridWidth,
            int gridHeight, float weightX, float weightY, Insets insets
            , int anchor
    ) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = fill;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.gridwidth = gridWidth;
        constraints.gridheight = gridHeight;
        constraints.weightx = weightX;
        constraints.weighty = weightY;
        constraints.insets = insets;
        constraints.anchor = anchor;

        contentPane.add(Component, constraints);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArchiveConsole();
            }
        });
    }
}


