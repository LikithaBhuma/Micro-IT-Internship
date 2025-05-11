import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import org.json.JSONObject;
public class CurrencyConverter extends JFrame implements ActionListener {
    JTextField sourceCurrency, targetCurrency, amount, result;
    JButton convertButton;
    public CurrencyConverter() {
        setTitle("Currency Converter");
        setLayout(null);
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel titleLabel = new JLabel("Currency Converter");
        titleLabel.setBounds(200, 10, 200, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(150, 60, 120, 30);
        add(amountLabel);

        amount = new JTextField();
        amount.setBounds(280, 60, 150, 30);
        add(amount);

        JLabel sourceLabel = new JLabel("From (e.g., USD):");
        sourceLabel.setBounds(150, 110, 120, 30);
        add(sourceLabel);

        sourceCurrency = new JTextField();
        sourceCurrency.setBounds(280, 110, 150, 30);
        add(sourceCurrency);

        JLabel targetLabel = new JLabel("To (e.g., INR):");
        targetLabel.setBounds(150, 160, 120, 30);
        add(targetLabel);

        targetCurrency = new JTextField();
        targetCurrency.setBounds(280, 160, 150, 30);
        add(targetCurrency);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(150, 210, 120, 30);
        add(resultLabel);

        result = new JTextField();
        result.setBounds(280, 210, 150, 30);
        result.setEditable(false);
        add(result);

        convertButton = new JButton("Convert");
        convertButton.setBounds(230, 260, 120, 30);
        convertButton.addActionListener(this);
        add(convertButton);

        // Optional: Currency table remains the same
        String[][] data = {
            {"USD", "US Dollar"}, {"EUR", "Euro"}, {"INR", "Indian Rupee"}, {"JPY", "Japanese Yen"},
            {"GBP", "British Pound"}, {"AUD", "Australian Dollar"}, {"CAD", "Canadian Dollar"},
            {"CHF", "Swiss Franc"}, {"CNY", "Chinese Yuan"}, {"SGD", "Singapore Dollar"},
            {"NZD", "New Zealand Dollar"}, {"ZAR", "South African Rand"}, {"SEK", "Swedish Krona"},
            {"NOK", "Norwegian Krone"}, {"MXN", "Mexican Peso"}, {"RUB", "Russian Ruble"},
            {"KRW", "South Korean Won"}, {"BRL", "Brazilian Real"}, {"HKD", "Hong Kong Dollar"},
            {"TRY", "Turkish Lira"}, {"AED", "UAE Dirham"}, {"SAR", "Saudi Riyal"},
            {"DKK", "Danish Krone"}, {"PLN", "Polish Zloty"}, {"THB", "Thai Baht"},
            {"MYR", "Malaysian Ringgit"}, {"IDR", "Indonesian Rupiah"}, {"PHP", "Philippine Peso"},
            {"CZK", "Czech Koruna"}, {"HUF", "Hungarian Forint"}
        };

        String[] columnNames = {"Code", "Currency"};
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 310, 400, 180);
        add(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amount.getText().trim());
            String from = sourceCurrency.getText().trim().toUpperCase();
            String to = targetCurrency.getText().trim().toUpperCase();

            if (from.isEmpty() || to.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter both currency codes.");
                return;
            }

            String apiKey = "add your own API KEY";
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + from;

            URL url = new URL(urlStr);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader((InputStream) request.getContent()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();

            JSONObject json = new JSONObject(response.toString());

            if (!json.getJSONObject("conversion_rates").has(to)) {
                JOptionPane.showMessageDialog(this, "Invalid currency code.");
                return;
            }

            double rate = json.getJSONObject("conversion_rates").getDouble(to);
            double convertedAmount = amount * rate;

            result.setText(String.format("%.2f %s", convertedAmount, to));
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
