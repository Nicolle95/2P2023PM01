package com.example.a2p2023pm01.Configuracion;

public class Transaccion {

/* nombre de la base de datos */
  public static final String NameDatabase = "PMO1DB";

  // tablas de base de datos
    public static final String tablaPersonas = "personas";

    // campos de la tabla personas
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";

    // DDL Create and Drop
  public static final String CreateTablePersona = "CREATE TABLE PERSONAS "+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT, edad INTEGER, "+
            "correo TEXT )";

  public static final String DROPTablePersonas = "DROP TABLE IF EXITS personas";

  //DML
  public static final String SelectTablePersona = " SELECT * FROM " + Transaccion.tablaPersonas;
}
