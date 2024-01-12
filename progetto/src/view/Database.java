package view;
import java.sql.*;

public class Database {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String dbUrl;
	private String username;
	private String pwd;
	private	Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public Database(String dbUrl, String username, String pwd) {
		
		this.dbUrl = dbUrl;
		this.username = username;
		this.pwd = pwd;
		
		try {
			//avvio il driver
			Class.forName(driver);
			
			//mi connetto al database
			System.out.println("Provo a connettermi al database...");
			conn = DriverManager.getConnection(dbUrl,username,pwd);
			System.out.println("Connesso");
			
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public boolean isConnected() {
		if(conn != null) return true;
		else return false;
	}
	
	public ResultSet query1() {
		try {	
			rs = st.executeQuery(QUERY1);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query2() {
		try {	
			rs = st.executeQuery(QUERY2);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query3() {
		try {	
			rs = st.executeQuery(QUERY3);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query4() {
		try {	
			rs = st.executeQuery(QUERY4);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query5() {
		try {	
			rs = st.executeQuery(QUERY5);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query6() {
		try {	
			rs = st.executeQuery(QUERY6);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query7() {
		try {	
			rs = st.executeQuery(QUERY7);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query8() {
		try {	
			rs = st.executeQuery(QUERY8);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query9() {
		try {	
			rs = st.executeQuery(QUERY9);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query10() {
		try {	
			rs = st.executeQuery(QUERY10);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query11() {
		try {	
			rs = st.executeQuery(QUERY11);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query12(int gara) {
		try {	
			pst = conn.prepareStatement(QUERY12, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pst.setInt(1, gara);
			rs = pst.executeQuery();
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query13() {
		try {	
			rs = st.executeQuery(QUERY13);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query14() {
		try {	
			rs = st.executeQuery(QUERY14);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query15() {
		try {	
			rs = st.executeQuery(QUERY15);
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet query16(int vettura) {
		try {
			pst = conn.prepareStatement(QUERY16, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pst.setInt(1, vettura);

			rs = pst.executeQuery();
			if(rs == null) System.out.println("Nessun risultato");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean insert1(String nome, String sede) {
		boolean flag = false;
		String insert = "INSERT INTO scuderia (Nome, Sede) VALUES (?,?)";
		try {
			pst = conn.prepareStatement(insert);
			pst.setString(1, nome);
			pst.setString(2, sede);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean insert2(int numeroDaGara, String scuderia, String modello) {
		boolean flag = false;
		String insert = "INSERT INTO vettura (`Numero da gara`, Scuderia, Modello) VALUES (?, ?, ?)";
		try {
			pst = conn.prepareStatement(insert);
			pst.setInt(1, numeroDaGara);
			pst.setString(2, scuderia);
			pst.setString(3, modello);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean insert3(int vettura, String nome, String cognome, String dataNascita, String nazionalita, String dataPrimaLicenza, Integer numLicenze) {
		boolean flag = false;
		String insert = "INSERT INTO pilota (Vettura, Nome, Cognome, `Data nascita`, Nazionalità, `Data prima licenza`, `Numero licenze`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(insert);
			pst.setInt(1, vettura);
			pst.setString(2, nome);
			pst.setString(3, cognome);
			pst.setString(4, dataNascita);
			pst.setString(5,  nazionalita);
			pst.setString(6, dataPrimaLicenza);
			pst.setObject(7, numLicenze);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean insert4(int vettura, String scuderia, String nome, String cognome, String dataNascita, String nazionalita, String dataPrimaLicenza, int quota) {
		boolean flag = false;
		String insert = "INSERT INTO `gentleman driver` (Vettura, Scuderia, Nome, Cognome, `Data nascita`, Nazionalità, `Data prima licenza`, Quota) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			if(!checkEquipaggio(vettura)){
				new ErrorException("L'equipaggio non può essere composto solo da gentleman driver!");
			}else {
				pst = conn.prepareStatement(insert);
				pst.setInt(1, vettura);
				pst.setString(2, scuderia);
				pst.setString(3, nome);
				pst.setString(4, cognome);
				pst.setString(5, dataNascita);
				pst.setString(6,  nazionalita);
				pst.setString(7, dataPrimaLicenza);
				pst.setInt(8, quota);
				pst.executeUpdate();
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			if(e.getMessage().equalsIgnoreCase("La vettura scelta dal GentlemanDriver non appartiene alla scuderia finanziata")){
				new ErrorException("La vettura scelta dal GentlemanDriver non appartiene alla scuderia finanziata!");
			}
		}

		return flag;
	}
	
	public boolean insert5(int gara, int vettura) {
		boolean flag = false;
		String insert = "INSERT INTO iscrizione (Gara, Vettura) VALUES (?, ?)";
		try {
			pst = conn.prepareStatement(insert);
			pst.setInt(1, gara);
			pst.setInt(2, vettura);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean insert6(int gara, int vettura, int piazzamento, String motivoRitiro) {
		 boolean flag = false;
		    int modifiche = 0;

		    // Verifica se il piazzamento esiste già
		    if (piazzamentoEsistente(gara, piazzamento)) {
		        throw new ErrorException("Piazzamento già esistente!");
		    }

		    String update = "UPDATE iscrizione "
		            + "SET Piazzamento = ?, `Motivo ritiro` = ? "
		            + "WHERE Gara = ? AND Vettura = ?";
		    try {
		        pst = conn.prepareStatement(update);
		        pst.setInt(1, piazzamento);
		        pst.setString(2, motivoRitiro);
		        pst.setInt(3, gara);
		        pst.setInt(4, vettura);
		        modifiche = pst.executeUpdate();

		        if (modifiche > 0) {
		            flag = true; // Imposta il flag su true solo se ci sono state modifiche
		        } else {
		            throw new ErrorException("Vettura non iscritta alla gara!");
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return flag;
	}

	public boolean piazzamentoEsistente(int gara, int piazzamento) {
		String check = "SELECT COUNT(*) FROM iscrizione WHERE Gara = ? AND Piazzamento = ?";
		try {
			pst = conn.prepareStatement(check);
			pst.setInt(1, gara);
			pst.setInt(2, piazzamento);
			rs = pst.executeQuery();
			
			rs.next();
			if(rs.getInt(1) > 0) {
				return true;
			}else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean delete1(int vettura) {
		boolean flag = false;
		String delete = "DELETE FROM cambio WHERE cambio.Vettura = ?";
		try {
			pst = conn.prepareStatement(delete);
			pst.setInt(1, vettura);
			
			int modifiche = pst.executeUpdate();
			if(modifiche>0) {
				flag = true;
			}else flag = false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean delete2(int vettura) {
		boolean flag = false;
		String delete = "DELETE FROM motore WHERE motore.Vettura = ?";
		try {
			pst = conn.prepareStatement(delete);
			pst.setInt(1, vettura);
			
			int modifiche = pst.executeUpdate();
			if(modifiche>0) {
				flag = true;
			}else flag = false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean delete3(int vettura) {
		boolean flag = false;
		String delete = "DELETE FROM telaio WHERE telaio.Vettura = ?;";
		try {
			pst = conn.prepareStatement(delete);
			pst.setInt(1, vettura);
			
			int modifiche = pst.executeUpdate();
			if(modifiche>0) {
				flag = true;
			}else flag = false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean insertCambio(int vettura, String costruttore, int costo, String dataInstallazione, int numMarce) {
		boolean flag = false;
		String insert = "INSERT INTO cambio (Vettura, Costruttore, Costo, `Data installazione`, `Numero marce`) VALUES (?, ?, ?, ?, ?)";
		
		try {
			pst = conn.prepareStatement(insert);
			pst.setInt(1, vettura);
			pst.setString(2, costruttore);
			pst.setInt(3, costo);
			pst.setString(4, dataInstallazione);
			pst.setInt(5, numMarce);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean insertMotore(int vettura, String costruttore, int costo, String dataInstallazione, int cilindrata, int numCilindri, String tipo) {
		boolean flag = false;
		String insert = "INSERT INTO motore (Vettura, Costruttore, Costo, `Data installazione`, Cilindrata, `Numero cilindri`, Tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(insert);
			pst.setInt(1, vettura);
			pst.setString(2, costruttore);
			pst.setInt(3, costo);
			pst.setString(4, dataInstallazione);
			pst.setInt(5, cilindrata);
			pst.setInt(6, numCilindri);
			pst.setString(7, tipo);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean insertTelaio(int vettura, String costruttore, int costo, String dataInstallazione, String composizione, int peso) {
		boolean flag = false;
		String insert = "INSERT INTO telaio (Vettura, Costruttore, Costo, `Data installazione`, Composizione, Peso) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(insert);
			pst.setInt(1, vettura);
			pst.setString(2, costruttore);
			pst.setInt(3, costo);
			pst.setString(4, dataInstallazione);
			pst.setString(5, composizione);
			pst.setInt(6, peso);
			pst.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean checkEquipaggio(int vettura) {
		String query = "SELECT `Numero di piloti` FROM vettura WHERE `Numero da gara` = " + vettura;
		int numPiloti = 0;
		try {
			rs = st.executeQuery(query);
			rs.next();
			numPiloti = rs.getInt("Numero di piloti");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(numPiloti>0) return true;
		else return false;
	}
	
	private final String QUERY1 = "SELECT scuderia.Nome AS Scuderia, COALESCE(SUM(`gentleman driver`.quota), 0) AS `Quota totale` "
			+ "FROM scuderia "
			+ "LEFT JOIN "
			+ "`gentleman driver` "
			+ "ON scuderia.Nome = `gentleman driver`.Scuderia "
			+ "GROUP BY scuderia.Nome "
			+ "ORDER BY `Quota totale` DESC";
	
	private final String QUERY2 = "SELECT scuderia.Nome AS Scuderia, Scuderia.Sede AS Sede, COUNT(`gentleman driver`.quota) AS `Numero Finanziamenti` "
			+ "FROM scuderia "
			+ "LEFT JOIN "
			+ "`gentleman driver` "
			+ "ON Scuderia.Nome = `gentleman driver`.Scuderia "
			+ "GROUP BY Scuderia.Nome";
	
	private final String QUERY3 = "SELECT pilota.ID AS ID_Pilota, pilota.Vettura, pilota.Nome, pilota.Cognome, pilota.Nazionalità, Gara.Nome AS Gara "
			+ "FROM pilota JOIN vettura "
			+ "ON pilota.Vettura = vettura.`Numero da gara` "
			+ "JOIN iscrizione "
			+ "ON vettura.`Numero da gara` = iscrizione.Vettura "
			+ "JOIN gara "
			+ "ON iscrizione.Gara = gara.ID "
			+ "JOIN circuito "
			+ "ON gara.Circuito = circuito.Nome "
			+ "WHERE pilota.nazionalità = circuito.Paese AND iscrizione.Piazzamento = '1' "
			+ "UNION "
			+ "SELECT `gentleman driver`.ID, `gentleman driver`.Vettura, `gentleman driver`.Nome, `gentleman driver`.Cognome, `gentleman driver`.Nazionalità, Gara.Nome "
			+ "FROM `gentleman driver` JOIN vettura "
			+ "ON `gentleman driver`.Vettura = vettura.`Numero da gara` "
			+ "JOIN iscrizione "
			+ "ON vettura.`Numero da gara` = iscrizione.Vettura "
			+ "JOIN gara "
			+ "ON iscrizione.Gara = gara.ID "
			+ "JOIN circuito "
			+ "ON gara.Circuito = circuito.Nome "
			+ "WHERE `gentleman driver`.nazionalità = circuito.Paese AND iscrizione.Piazzamento = '1' ";
	
	private final String QUERY4 = "SELECT scuderia.Nome AS Scuderia, COUNT(`gentleman driver`.ID) / SUM(DISTINCT vettura.`Numero di piloti`) * 100 AS percentualeGD "
			+ "FROM scuderia JOIN vettura "
			+ "ON scuderia.Nome = vettura.Scuderia "
			+ "JOIN `gentleman driver` "
			+ "ON `gentleman driver`.Vettura = vettura.`Numero da gara` "
			+ "GROUP BY scuderia.Nome";
	
	private final String QUERY5 = "SELECT costruttore.Nome AS Costruttore, costruttore.`Ragione sociale`, costruttore.`Numero componenti` AS `Componenti forniti`"
			+ "FROM costruttore";
	
	private final String QUERY6 = "SELECT ROW_NUMBER() OVER (ORDER BY vettura.`Numero di punti` DESC) AS Posizione, "
			+ "vettura.`Numero da gara` AS Vettura, vettura.`Numero di punti` AS Punti "
			+ "FROM vettura "
			+ "ORDER BY Posizione";
	
	private final String QUERY7 = "SELECT "
			+ "	ROW_NUMBER() OVER (PARTITION BY `Tipo motore` ORDER BY Punti DESC) AS Posizione, "
			+ "    `Tipo motore`, "
			+ "    Vettura, "
			+ "    Punti "
			+ "FROM "
			+ "    ( "
			+ "        SELECT "
			+ "            motore.`Tipo` AS `Tipo motore`, "
			+ "            vettura.`Numero da gara` AS Vettura, "
			+ "            vettura.`Numero di punti` AS Punti "
			+ "        FROM "
			+ "            vettura "
			+ "        JOIN "
			+ "            motore ON vettura.`Numero da gara` = motore.`Vettura` "
			+ "    ) AS ClassificaMotore "
			+ "ORDER BY "
			+ "	`Tipo motore`, "
			+ " Posizione";
	
	private final String QUERY8 = "SELECT "
			+ "ROW_NUMBER() OVER (ORDER BY `Rapporto punti/minuti` DESC) AS Posizione, "
			+ "Classifica.Scuderia, "
			+ "`Rapporto punti/minuti` "
			+ "FROM ( "
			+ "	SELECT "
			+ "	vettura.Scuderia, SUM(DISTINCT vettura.`Numero di punti`) / SUM(TIME_TO_SEC(gara.Durata) / 60) AS `Rapporto punti/minuti` "
			+ "	FROM vettura "
			+ "	JOIN iscrizione "
			+ "	ON iscrizione.Vettura = vettura.`Numero da gara` "
			+ "	JOIN gara "
			+ "	ON iscrizione.Gara = gara.ID "
			+ "	GROUP BY vettura.Scuderia "
			+ ") AS Classifica "
			+ "ORDER BY `Rapporto punti/minuti` DESC";
	
	private final String QUERY9 = "SELECT * FROM vettura";
	
	private final String QUERY10 = "SELECT * FROM gara";
	
	private final String QUERY11 = "SELECT Gara, Vettura, scuderia.Nome AS Scuderia, Punti, Piazzamento, `Motivo ritiro` "
			+ "FROM iscrizione, scuderia, vettura "
			+ "WHERE iscrizione.Vettura = vettura.`Numero da gara` AND vettura.Scuderia = scuderia.Nome "
			+ "ORDER BY Gara";
	
	private final String QUERY12 = "SELECT "
			+ "ROW_NUMBER() OVER (ORDER BY iscrizione.Punti DESC) AS `Posizione`, "
			+ "iscrizione.Vettura, "
			+ "iscrizione.Punti "
			+ "FROM iscrizione "
			+ "WHERE iscrizione.Gara = ? "
			+ "ORDER BY `Posizione`";
	
	private final String QUERY13 = "SELECT * FROM costruttore";
	
	private final String QUERY14 = "SELECT * FROM pilota";
	
	private final String QUERY15 = "SELECT * FROM `gentleman driver`";
	
	private final String QUERY16 = "SELECT "
			+ "    COUNT(cambio.`Codice`) AS 'Numero di Cambi', "
			+ "    COUNT(motore.`Codice`) AS 'Numero di Motori', "
			+ "    COUNT(telaio.`Codice`) AS 'Numero di Telai' "
			+ "FROM "
			+ "vettura "
			+ "LEFT JOIN cambio ON vettura.`Numero da gara` = cambio.Vettura "
			+ "LEFT JOIN motore ON vettura.`Numero da gara` = motore.Vettura "
			+ "LEFT JOIN telaio ON vettura.`Numero da gara` = telaio.Vettura "
			+ "WHERE "
			+ "    vettura.`Numero da gara` = ?";
	
}
