package Proyect;

import java.io.*;

public class Empresa_De_Taxi{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int N = 0;
        int opc;
        String NombreClientes [] = new String[100];
        String[] DireccionesOrigen = new String[100];
        double[] CostosServicio = new double[100];
        String nombre[] = new String[100];
        char estado[] = new char[100];
        int  ID[] =  new int [100];
        int NTotalServicios[] = new int[100];
        double IngTotalxUnidad[] = new double[100];
        int IDnuevo[]=new int [100];
        int Nservicios=0;
        do {
        opc = ReservaMenu();
        switch (opc) {
            case 1:
                if (N==0) {
                    N = LeerNUnidadesDeTaxi();  
                    IngresarArreglos(N, nombre, ID, estado,  NTotalServicios, IngTotalxUnidad);
                } else {
                    Aviso1();
                }
                break;
            case 2:
                if (N>0) {
                    ReportarArreglos(N, nombre, ID, estado,  NTotalServicios, IngTotalxUnidad);
                } else {
                    Aviso2();
                }         
                break;
            case 3:
                if (N>0) {
                    N = AgregarArreglos(N, nombre, ID, estado,  NTotalServicios, IngTotalxUnidad);
                } else {
                    Aviso3();
                }
                break;
            case 4:
                if (N>0) {
                    ModificarArreglos(N, nombre, ID, estado,  NTotalServicios, IngTotalxUnidad);
                } else {
                    Aviso2();
                }
                break;
            case 5:
                if (N>0) {
                    N = EliminarArreglos(N, nombre, ID, estado,  NTotalServicios, IngTotalxUnidad);
                } else {
                    Aviso4();
                }
                break;
            case 6:
                if (N>0) {
                    ConsultarNombre(N, nombre, ID, estado,  NTotalServicios, IngTotalxUnidad);
                } else {
                    Aviso2();
                }
                break;
            case 7:
                if (N>0) {
                    ConsultarID(N, nombre, ID, estado, NTotalServicios, IngTotalxUnidad);
                } else {
                    Aviso2();
                }
                
                break;
            case 8:
                if (N>0) {
                    OrdenarDatosAlfabeticamente(N,nombre,ID,estado,NTotalServicios,IngTotalxUnidad);
                } else {
                    Aviso2();
                }
                
                break;
            case 9:
                if (N>0) {
                    ordenarPorIdTaxiDescendente(N,nombre,ID,estado,NTotalServicios,IngTotalxUnidad);
                } else {
                    Aviso2();
                }
                break;
            case 10:
                if (N>0) {
                   Nservicios = AsignarServicios(N,nombre,ID,estado,NTotalServicios,IngTotalxUnidad, NombreClientes, DireccionesOrigen, CostosServicio,Nservicios,IDnuevo);
                } else {
                    Aviso2();
                }
                break;
            case 11:
                if (N>0) {
                    CambioServicios(N,nombre,ID,estado,NTotalServicios,IngTotalxUnidad, NombreClientes, DireccionesOrigen, CostosServicio,Nservicios,IDnuevo);
                } else {
                    Aviso2();
                }
                break;
            case 12:
                Terminar();
                break;
        }
        } while (opc !=12);
    }
    //Creación del menu para las opciones
    public static int ReservaMenu() throws IOException{
        int opc;
        do {
            System.out.println("-------------------------------------------------------");
            System.out.println("\tReserva de Servicio de TaxisFly");
            System.out.println("\n");
            System.out.println("[1] --> Ingresar Datos");
            System.out.println("[2] --> Reportar Datos");
            System.out.println("[3] --> Agregar Datos");
            System.out.println("[4] --> Modificar Datos");
            System.out.println("[5] --> Eliminar Datos");
            System.out.println("[6] --> Consultar por nombre del conductor");
            System.out.println("[7] --> Consultar por IDtaxi");
            System.out.println("[8] --> Ordenar datos alfabeticamente");
            System.out.println("[9] --> Ordenar datos de manera descendente");
            System.out.println("[10] --> Asignacion de servicio a una unidad de taxi");
            System.out.println("[11] --> Fin del servicio");
            System.out.println("[12] --> Terminar");
            System.out.println("Seleccione un numero");
            opc = Integer.parseInt(br.readLine());
        } while (opc<1 || opc>12);
        return opc;
    }
    // Leer el numero de Unidades de Taxis y validar que sea un numero y no otro caracter
    public static int LeerNUnidadesDeTaxi() throws IOException {
    int N;
    do {
        System.out.println("\nIngrese las N unidades de taxi");
        N = Integer.parseInt(br.readLine());
    } while (N <= 0 || N > 100);
    return N;
    }
    // Ingresar nombre de cada arreglo (Nombre de conductor, ID taxi, estado civil, N Total de servicios e ingresoTotalxUnidad)
    public static void IngresarArreglos(int N, String[] nombre, int [] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad) throws IOException {
        boolean IDRepetido;
        for (int i = 0; i < N; i++) {
            System.out.println("\tINGRESO DE DATOS "+(i+1));
            System.out.println("Unidad de taxi #" + (i + 1));
            System.out.print("Nombre del conductor: ");
            nombre[i] = br.readLine().toUpperCase();
            do {
                IDRepetido = false;
                System.out.print("Ingrese el ID del conductor (3 digitos): ");
                ID[i] = Integer.parseInt(br.readLine());
                if (ID[i]< 100 || ID[i] > 999) {
                    System.out.println("\t\tSe ha ingresado un ID de menos de 3 digitos o mas");
                    System.out.println("\t\tVolver a ingresar el ID");
                }
                for (int j = 0; j < i; j++) {
                    if (ID[i] == ID[j]) {
                        System.out.println("\tERROR... El ID ya esta en uso. Por favor, ingrese un ID diferente");
                        IDRepetido = true;
                        break;
                    }
                }                     
            } while (ID[i]< 100 || ID[i] > 999 || IDRepetido);           
        }
        for (int i = 0; i < N; i++) {
            estado[i]='L';
            NTotalServicios[i]=0;
            IngTotalxUnidad[i]=0;
        }
    }
    //Reportar datos de las unidades de taxi ingresadas y agregadas
    public static void ReportarArreglos(int N, String[] nombre, int [] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad) throws IOException {
        System.out.println("\nCantidad de datos ingresados --------------------> # "+N+"\n");
        System.out.println("\tREPORTE DE DATOS\n ");
        System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
        for (int i = 0; i < N; i++) {
            System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i] +"\t\t"+estado[i] +"\t\t\t"+NTotalServicios[i] +"\t\t\t"+IngTotalxUnidad[i]);
        }
    }
    //Agregar datos de las unidades de taxi ingresadas
    public static int AgregarArreglos (int N, String[] nombre, int [] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad) throws IOException {
        boolean IDRepetido;
            if (N<100) {
                System.out.print("\nIngrese el nombre del conductor: ");
                nombre[N] = br.readLine().toUpperCase();
                do {
                    IDRepetido = false;
                    System.out.print("Ingrese el ID del conductor (3 digitos): ");
                    ID[N] = Integer.parseInt(br.readLine());
                    for (int j = 0; j < N; j++) {
                        if (ID[N] == ID[j]) {
                            System.out.println("\t\tEl ID ya esta en uso. Por favor, ingrese un ID diferente");
                            IDRepetido = true;
                            break;
                        }
                    }
                    if (ID[N]< 100 || ID[N] > 999) {
                        System.out.println("\tERROR... El id tiene que tener 3 digitos");
                        System.out.println("\tVUELVA A INGRESAR EL ID");
                    }
                } while (ID[N]< 100 || ID[N] > 999 || IDRepetido);
                estado[N]='L';
                NTotalServicios[N]=0;
                IngTotalxUnidad[N]=0;
                System.out.println("\n");
                N = N+1;
            } else {
                System.out.println("\tError... Arreglo completo");
            }
            // Reportar datos
            System.out.println("\nCantidad de datos ingresados --------------------> # "+N+"\n");
            System.out.println("\tREPORTE DE DATOS\n ");
            System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
            for (int i = 0; i < N; i++) {
                System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i] +"\t\t"+estado[i] +"\t\t\t"+NTotalServicios[i] +"\t\t\t"+IngTotalxUnidad[i]);
            }
        
        return N;
    }
    //Modificar los datos de las unidades de taxi ingresadas
    public static void ModificarArreglos (int N, String[] nombre, int [] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad) throws IOException {
        System.out.println("\tREPORTE DE DATOS\n ");
        System.out.println("N |"+"\tNombre"+"\t\tID");
        for (int i = 0; i < N; i++) {
            System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i]);
        }
        System.out.println("Ingrese nombre a buscar");
        String nomaux = br.readLine().toUpperCase();
        boolean IDRepetido;
        int pos = -1;
        for (int i = 0; i < N; i++) {
            if (nombre[i].equals(nomaux)) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            System.out.println("\n Error... Dato inexistente, favor reintentar\n");
        } else {
            System.out.print("Ingrese el nuevo nombre del conductor: ");
            nombre[pos] = br.readLine().toUpperCase();
            do {
                IDRepetido = false;
                System.out.print("Ingrese el nuevo ID del conductor (3 digitos): ");
                ID[pos] = Integer.parseInt(br.readLine());
                for (int j = 0; j < pos; j++) {
                    if (ID[pos] == ID[j]) {
                        System.out.println("El ID ya esta en uso. Por favor, ingrese un ID diferente");
                        IDRepetido = true;
                        break;
                    }
                }
                if (ID[pos]< 100 || ID[pos] > 999) {
                    System.out.println("\tERROR... El id tiene que tener 3 digitos");
                    System.out.println("\tVUELVA A INGRESAR EL ID");
                }
            } while (ID[pos]< 100 || ID[pos] > 999 || IDRepetido);
            // Reportar datos
            System.out.println("\nCantidad de datos ingresados --------------------> # "+N+"\n");
            System.out.println("\tREPORTE DE DATOS\n ");
            System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
            for (int i = 0; i < N; i++) {
                System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i] +"\t\t"+estado[i] +"\t\t\t"+NTotalServicios[i] +"\t\t\t"+IngTotalxUnidad[i]);
            }
            System.out.println("\n");
        }       
    }
    //Consultar datos por el nombre de conductor de taxi
    public static void ConsultarNombre (int N, String[] nombre, int [] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad) throws IOException {
        int pos = -1;
        System.out.println("N |"+"\tNombre");
        for (int i = 0; i < N; i++) {
            System.out.println((i+1)+" |"+"\t"+nombre[i]);
        }
        System.out.println("Ingrese nombre del conductor");
        String nomaux = br.readLine().toUpperCase();
        for (int i = 0; i < N; i++) {
            if (nombre[i].equals(nomaux)) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            System.out.println("\n Error... Dato inexistente, favor reintentar\n");
        } else {
            System.out.println("\nImprimiendo Resultados...");
            System.out.println("Dato encontrado... Procediendo...\n");
            System.out.println("\tINFORMACION DEL CONDUCTOR");
            System.out.println("Nombre del conductor: " + nombre[pos]);
            System.out.println("\tDATOS:\n");
            System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
            System.out.println((pos)+" |"+"\t"+nombre[pos]+"\t"+"\t"+ID[pos] +"\t\t"+estado[pos] +"\t\t\t"+NTotalServicios[pos] +"\t\t\t"+IngTotalxUnidad[pos]);
        }
    }
    //Eliminar datos por el nombre del conductor de taxi
    public static int EliminarArreglos (int N, String[] nombre, int [] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad) throws IOException {
        String nomaux;
        int pos = -1;
        System.out.println("\tREPORTE DE DATOS\n ");
        System.out.println("N |"+"\tNombre"+"\t\tID");
        for (int i = 0; i < N; i++) {
            System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i]);
        }
        System.out.println("Ingrese el nombre del conductor");
        nomaux = br.readLine().toUpperCase();
        for (int i = 0; i < N; i++) {
            if (nombre[i].equals(nomaux)) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            System.out.println("\n Error... Dato inexistente, favor reintentar\n");    
        } else {
            nombre[pos] = nombre[N-1];
            ID[pos] = ID[N-1];
            estado[pos] = estado[N-1];
            NTotalServicios[pos] = NTotalServicios[N-1];
            IngTotalxUnidad[pos] = IngTotalxUnidad[N-1];
            N = N-1;
        }
        System.out.println("Dato eliminado con exito");
        System.out.println("\nTabla actualizada:\n");
        System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
        for (int i = 0; i < N; i++) {
            System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i] +"\t\t"+estado[i] +"\t\t\t"+NTotalServicios[i] +"\t\t\t"+IngTotalxUnidad[i]);
        }
        return N;
    }
    // Consultar datos por el ID del conductor del taxi.
    public static void ConsultarID(int N, String[] nombre, int[] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad) throws IOException{
        int pos=-1;
        System.out.println("\tREPORTE DE DATOS\n ");
        System.out.println("N |"+"\t\tID");
        for (int i = 0; i < N; i++) {
            System.out.println((i+1)+" |"+"\t\t"+ID[i]);
        }
        System.out.println("Ingrese ID del conductor");
        int Idex = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if(ID[i]==(Idex)) {
                pos=i;
                break;        
            }
            }
            if (pos==-1) {
                System.out.println("\n Error... Dato inexistente, favor reintentar\n");
            
        } else {
            System.out.println("\nImprimiendo Resultados...");
            System.out.println("Dato encontrado... Procediendo...\n");
            System.out.println("\tINFORMACION DEL CONDUCTOR");
            System.out.println("ID del conductor: " + ID [pos]);
            System.out.println("\tDATOS:\n");
            System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
            System.out.println((pos)+" |"+"\t"+nombre[pos]+"\t"+"\t"+ID[pos] +"\t\t"+estado[pos] +"\t\t\t"+NTotalServicios[pos] +"\t\t\t"+IngTotalxUnidad[pos]);
        }
    }
    // Ordenar datos alfabéticamente en forma ascendente por nombre del conductor
    public static void OrdenarDatosAlfabeticamente(int N, String[] nombre, int[] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad)throws IOException {
        String nombreaux;
        int IDaux;
        char estadoaux;
        int NTotalServiciosaux;
        double IngTotalxUnidadaux;
        for (int i = 0; i < N; i++) {
            for (int j=i+1 ; j < N; j++) {
                if (nombre[i].compareTo(nombre[j])>0) {
                    nombreaux=nombre[i];
                    nombre[i]=nombre[j];
                    nombre[j]=nombreaux;
                    IDaux=ID[i];
                    ID[i]=ID[j];
                    ID[j]=IDaux;               
                    estadoaux=estado[i];
                    estado[i]=estado[j];
                    estado[j]=estadoaux;                  
                    NTotalServiciosaux=NTotalServicios[i];
                    NTotalServicios[i]=NTotalServicios[j];
                    NTotalServicios[j]=NTotalServiciosaux;
                    IngTotalxUnidadaux=IngTotalxUnidad[i];
                    IngTotalxUnidad[i]=IngTotalxUnidad[j];
                    IngTotalxUnidad[j]=IngTotalxUnidadaux;
                    
                }
            }
        }
        System.out.println("\tREPORTE DE DATOS\n ");
        System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
        for (int i = 0; i < N; i++) {
            System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i] +"\t\t"+estado[i] +"\t\t\t"+NTotalServicios[i] +"\t\t\t"+IngTotalxUnidad[i]);
        }
        System.out.println("\n");
    }
    //Ordenar datos de forma descendente por IdTaxi
    public static void ordenarPorIdTaxiDescendente(int N, String[] nombre, int[] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad)throws IOException {
        String nomaux;
        int IDaux;
        char estadoaux;
        int NTotalServiciosaux;
        double IngTotalxUnidadaux;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (ID[j] > ID[i]) {
                    nomaux = nombre[j];
                    nombre[j] = nombre[i];
                    nombre[i] = nomaux;
                    IDaux = ID[j];
                    ID[j] = ID[i];
                    ID[i] = IDaux;
                    estadoaux = estado[j];
                    estado[j] = estado[i];
                    estado[i] = estadoaux;
                    NTotalServiciosaux = NTotalServicios[j];
                    NTotalServicios[j] = NTotalServicios[i];
                    NTotalServicios[i] = NTotalServiciosaux;
                    IngTotalxUnidadaux = IngTotalxUnidad[j];
                    IngTotalxUnidad[j] = IngTotalxUnidad[i];
                    IngTotalxUnidad[i] = IngTotalxUnidadaux;    
                }
            }   
        }
        System.out.println("\tREPORTE DE DATOS\n ");
        System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
        for (int i = 0; i < N; i++) {
            System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i] +"\t\t"+estado[i] +"\t\t\t"+NTotalServicios[i] +"\t\t\t"+IngTotalxUnidad[i]);
        }
        System.out.println("\n");
    }
    //
    public static int AsignarServicios(int N, String[] nombre, int[] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad, String [] NombresClientes, String [] DireccionesOrigen, double [] CostoServicios,int Nservicios,int IDnuevo[])throws IOException {
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Asignar servicio");
            System.out.println("2. Salir");
            System.out.print("Elige una opcion: ");
            opcion = Integer.parseInt(br.readLine());
                if (opcion == 1) {
                System.out.println("\tTABLA DE DATOS\n ");
                System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
                for (int i = 0; i < N; i++) {
                    System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i] +"\t\t"+estado[i] +"\t\t\t"+NTotalServicios[i] +"\t\t\t"+IngTotalxUnidad[i]);
                }
                System.out.println("\n");
                System.out.print("Ingresa el IdTaxi: ");
                int id = Integer.parseInt(br.readLine());
                int indice = -1;
                for (int i = 0; i < N; i++) {
                    if (ID[i] == id && estado[i] == 'L') {
                        IDnuevo[Nservicios]=id;
                        indice=i;
                        break;
                    }
                }
                if (indice != -1) {
                    estado[indice] = 'O';
                    CostoServicios[Nservicios] = 0;
                    System.out.print("Ingrese nombre del cliente: ");
                    NombresClientes[Nservicios] = br.readLine().toUpperCase();
                    System.out.print("Ingrese direccion de origen: ");
                    DireccionesOrigen[Nservicios] = br.readLine().toUpperCase();
                    
                    do {
                        System.out.print("Ingrese costo de servicio: ");
                        CostoServicios[Nservicios] = Double.parseDouble(br.readLine());     
                    } while (CostoServicios[Nservicios]<=0);
                    IngTotalxUnidad[indice]+=CostoServicios[Nservicios];
                    NTotalServicios[indice]++;
                    Nservicios++;
                    System.out.println("Servicio asignado correctamente.");
                    System.out.println("\tREPORTE DE DATOS ACTUALIZADO\n ");
                    System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
                    for (int i = 0; i < N; i++) {
                            System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i] +"\t\t"+estado[i] +"\t\t\t"+NTotalServicios[i] +"\t\t\t"+IngTotalxUnidad[i]);
                    }
                    System.out.println("\n");
                } else {
                    System.out.println("No se encontro una unidad libre con ese IdTaxi.");
                }            
            }
        } while (opcion!=2);
        return Nservicios;
    }
    public static void CambioServicios(int N, String[] nombre, int[] ID, char[] estado, int[] NTotalServicios, double[] IngTotalxUnidad, String [] NombresClientes, String [] DireccionesOrigen, double [] CostoServicios ,int Nservicios,int IDnuevo[])throws IOException {
        int opcion;
        double IngresoAcumulado = 0;
        for (int i = 0; i < N; i++) {
            IngresoAcumulado += IngTotalxUnidad[i];
        }
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Fin de servicio");
            System.out.println("2. Salir");
            System.out.print("Elige una opcion: ");
            opcion = Integer.parseInt(br.readLine());
            if (opcion == 1) {
                System.out.println("\tTABLA DE DATOS DE LOS CONDUCTORES\n ");
                System.out.println("N |"+"\tNombre"+"\t\tID"+"\t\tEstado(L / O)"+"\t\tN de servicios"+"\t\tIngreso total x Unidades");
                for (int i = 0; i < N; i++) {
                    System.out.println((i+1)+" |"+"\t"+nombre[i]+"\t"+"\t"+ID[i] +"\t\t"+estado[i] +"\t\t\t"+NTotalServicios[i] +"\t\t\t"+IngTotalxUnidad[i]);
                }
                System.out.println("\n");
                System.out.print("Ingresa el IdTaxi para finalizar el servicio: ");
                int id = Integer.parseInt(br.readLine());
                int indice = -1;
                for (int i = 0; i < N; i++) {
                    if (ID[i] == id && estado[i] == 'O') {
                        indice = i;
                        break;
                    }
                }
                
                if (indice != -1) {
                    estado[indice] = 'L';
                } else {
                    System.out.println("No se encontro una unidad ocupada con ese IdTaxi.");
                }
                System.out.println("\tTABLA DE DATOS DE LOS CLIENTES\n ");
                System.out.println("N |"+"\tNombre"+"\t\tDireccion"+"\t\tID TAXI"+"\t\tCosto de servicio");
                for (int i = 0; i < Nservicios; i++) {
                    System.out.println((i+1)+" |"+"\t"+NombresClientes[i]+"\t\t"+DireccionesOrigen[i]+"\t\t\t"+ID[i] +"\t\t"+CostoServicios[i]);
                }
                System.out.println("TOTAL----------------------------------------------------------------->"+ IngresoAcumulado );
                System.out.println("Servicio finalizado correctamente.");
            }
        } while (opcion != 2);
    }
    //Terminar el menu de opciones
     public static void Terminar() throws IOException{
        System.out.println("\n\tGracias por su visita a TaxisFly, espero verlo nuevamente pronto...!");
        System.out.println("\tFIN DEL PROGRAMA");
    }
    //Avisos de error
    public static void Aviso1() throws IOException{
        System.out.println("\nAVISO:"+"\tYa se ha registrado la cantidad de datos necesarios");
        System.out.println(" ");
    }
    public static void Aviso2() throws IOException{
        System.out.println("\nAVISO:"+"\tError... Falta ingresar datos. DIGITAR LA OPCION [1] DEL MENU PARA INGRESAR DATOS");
        System.out.println(" ");
    }
    public static void Aviso3() throws IOException{
        System.out.println("\nAVISO:"+"\tError... No hay espacio en los arreglos");
        System.out.println(" ");
    }
    public static void Aviso4() throws IOException{
        System.out.println("\nAVISO:"+"\tError... No hay datos que eliminar");
        System.out.println(" ");
    }
}