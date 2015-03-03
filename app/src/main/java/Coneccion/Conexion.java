package Coneccion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alvaro on 02/03/2015.
 */
public class Conexion extends SQLiteOpenHelper {

    //patron singleton
    private static Conexion instancia=null;

    //dATOS
    private static final String DATABASE_NAME = "Telefono";
    private static final int DATABASE_VERSION=1;

    //creacion de tablas
    private String tb1="CREATE TABLE frases (frase TEXT primarykey)";

    //modificacion de tablas

    //eliminacion de tablas

    //insercion de datos iniciales
    private String a1="insert into frases values ('¡El amor sobrelleva y soporta, arriesga y equilibra, el amor vence todo!')";
    private String a2="insert into frases values ('Donde la lampara del Santisimo arde y jamas se extingue, se consume nuestra alma para desposarse contigo.')";
    private String a3="insert into frases values ('La impotencia supone una vinculacion mas profunda y estrecha con la gracia.')";
    private String a4="insert into frases values ('El que quiere ganar los corazones, tiene que poner como prenda su propio corazón')";
    private String a5="insert into frases values ('Nada pasa por casualidad! todo viene de la bondad de Dios')";
    private String a6="insert into frases values ('Santa Madre, haz que las llagas que tu Hijo ha sufrido por mí, se graben profundamente en mi alma')";
    private String a7="insert into frases values ('¡Que mi vida sea un gran Magnificat!')";
    private String a8="insert into frases values ('Solamente la fe viva vence al mundo')";
    private String a9="insert into frases values ('Todo por amor, con alegría')";
    private String a10="insert into frases values ('El que me ha enviado no me deja nunca solo, Él está siempre conmigo, porque yo hago lo que le agrada')";
    private String a11="insert into frases values ('Cristo es mi vida y morir una ganancia')";
    private String a12="insert into frases values ('¡Sí, Padre, sí! que siempre se haga tu Voluntad, si me trae alegría, sufrimiento o dolor')";
    private String a13="insert into frases values ('Haz que el espíritu de servicialidad penetre profundamente en mis sentimientos de vida')";
    private String a14="insert into frases values ('La cruz bendice al mundo')";
    private String a15="insert into frases values ('Con María alegres por la esperanza')";
    private String a16="insert into frases values ('¡La voluntad del Padre Celestial sobre todas las cosas!')";
    private String a17="insert into frases values ('Rezo para que en Ud. se realice la voluntad de Dios')";
    private String a18="insert into frases values ('Que viva en mí el alma de María, para que cante en mi el Magnificat')";
    private String a19="insert into frases values ('Hazme ser un sacrificio de la misericordia')";
    private String a20="insert into frases values ('¡La soledad es fecunda!')";
    private String a21="insert into frases values ('En las manos del Padre hacia el hogar')";
    private String a22="insert into frases values ('¡Bienaventurados los de corazón puro porque verán a Dios!')";
    private String a23="insert into frases values ('¡Hazme ser sol para todos!')";
    private String a24="insert into frases values ('Permanezca Ud. alerta para todo lo bueno y busque en todo una sana medida')";
    private String a25="insert into frases values ('El Ángel del Señor anunció a María...')";
    private String a26="insert into frases values ('Bueno es todo lo que Él hace')";
    private String a27="insert into frases values ('¡Siempre de nuevo tengo que leer en el corazón de María, pues ningún otro libro aquí en la tierra nos guía más rápido hacia el cielo!')";
    private String a28="insert into frases values ('Yo vengo del Amor, vivo del Amor y vuelvo al Amor...')";
    private String a29="insert into frases values ('La semilla tiene que ser enterrada en la tierra y desaparecer, entonces trae mucho fruto')";
    private String a30="insert into frases values ('El verdadero amor no se siente nunca abandonado')";
    private String a31="insert into frases values ('¡Dios es un Dios de alegría y de paz!')";
    private String a32="insert into frases values ('Hazme Padre ser un milagro de misericordia, pues soy débil y pequeño')";
    private String a33="insert into frases values ('La fuerza del Altísimo te cubrirá con su sombra')";
    private String a34="insert into frases values ('Haga feliz a cuantas personas sea posible...')";
    private String a35="insert into frases values ('¡No os preocupéis angustiosamente! La mayor preocupación es ser infinitamente despreocupados')";
    private String a36="insert into frases values ('¡Quedamos en eso! ¡Permanecemos fieles!')";
    private String a37="insert into frases values ('...sea para muchas personas un indicador de camino, y portador de luz y de alegría')";
    private String a38="insert into frases values ('El que mantiene siempre abiertos el corazón y los sentidos para lo que agrada a Dios, permanece joven hasta la edad avanzada, porque nunca le falta la fuerza del amor')";
    private String a39="insert into frases values ('El amor es el poder más grande')";
    private String a40="insert into frases values ('Lleve Ud. su cruz tranquilo, humilde, valiente. ¡Así ayuda Ud. a salvar el mundo!')";
    private String a41="insert into frases values ('Mi destino descansa en las manos del Padre')";
    private String a42="insert into frases values ('¡Qué pocos católicos han experimentado real y vitalmente que:Dios es mi Padre!')";
    private String a43="insert into frases values ('Si no estoy unido al Dios personal, la vida nos enfermará. Necesitamos descansar en Dios')";
    private String a44="insert into frases values ('Lo que hoy salva al mundo es un gran desprendimiento, es el espíritu de sacrificio, y éste debe nacer del amor filial. El profundo amor filial enciende un desprendimiento increíble')";
    private String a45="insert into frases values ('Estar en Cristo Jesús, según Pablo, es sufrir con Cristo, morir y ser sepultado con Él, resucitar y vivir en Él, ser transfigurado y reinar con Él, participar de Él, estar incorporado y configurado a Él (cf. Rom 6,3-5; 6,11; 8,17; 2 Cor 5, 15)')";
    private String a46="insert into frases values ('La santidad es la configuración en Cristo, y Cristo ha hecho suya y ha conservado a través de toda su vida la actitud filial ante el Padre')";
    private String a47="insert into frases values ('Cuando el Espíritu Santo actúa en el alma de un modo profundamente eficaz, entonces el hijo tiene un solo ideal: cumplir el deseo del Padre, vivir en conformidad con la voluntad de Dios')";
    private String a48="insert into frases values ('Cumplir sólo lo que desea el Padre y cultivar el espíritu de hijos durante toda la vida, es algo tan maravillosamente grande, supera en tal forma el poder humano, que debemos decir: sin el Espíritu Santo esto es absolutamente imposible')";
    private String a49="insert into frases values ('Cuanto más desvalidos e indignos nos sintamos para recibir tales dones, tanto más abundantemente nos serán regalados')";
    private String a50="insert into frases values ('El camino mariano no es meramente un camino más, sino un camino excelente para hacernos hijos del Padre celestial')";
    private String a51="insert into frases values ('La Santísima Virgen es el modelo de la auténtica filialidad. Ella la aprendió del Hijo unigénito de Dios')";
    private String a52="insert into frases values ('Toda la vida de la Santísima Virgen es una concretización de la voluntad de Dios, una constante y absoluta entrega al deseo y a la voluntad del Padre')";
    private String a53="insert into frases values ('A la luz de la fe, veo la mano del Padre aún en los golpes del destino')";
    private String a54="insert into frases values ('Jesús recalca con frecuencia que Dios Padre se preocupa paternalmente de cada hombre, incluso hasta de las pequeñeces más insignificantes')";
    private String a55="insert into frases values ('Cuanto más incondicionalmente confíe en el Padre, tanto más incondicionalmente me manifestaré su amor paternal')";
    private String a56="insert into frases values ('Nuestra preocupación más grande debería ser estar infinitamente despreocupados en cada segundo, no por negligencia, sino porque confiamos en Dios')";
    private String a57="insert into frases values ('Los santos se han hecho santos desde el momento en que comenzaron a amar. Y esta verdad es correlativa a aquella otra: han comenzado a amar cuando se creyeron, se supieron y se sintieron amados')";
    private String a58="insert into frases values ('En la expresión: Abba, querido Padre, se expresa un cobijamiento, una tranquilidad y una paz sumamente profundas')";
    private String a59="insert into frases values ('Lo que nos fascina en el niño es especialmente su simplicidad, su rectitud, su sencillez')";
    private String a60="insert into frases values ('Me glorío de mi debilidad, porque mediante ella se manifiesta la fuerza de Cristo en mí')";
    private String a61="insert into frases values ('El hombre filial y humilde alcanzará de Dios todo cuanto quiera. Así lo dicen los santos, así lo dice también la Sagrada Escritura: ensalza a los pequeños')";
    private String a62="insert into frases values ('Para medir nuestra vida cristiana sólo necesitamos fijarnos cómo rezamos. ¡Con agrado, con alegría, con profundidad, constantemente? La respuesta nos da la idea de la autenticidad de nuestra cristianismo, de nuestra fe cristiana')";
    private String a63="insert into frases values ('Dios debe tocar nuestra corazón para que realmente aprendamos a orar')";
    private String a64="insert into frases values ('Quien no se domina en el hablar, jamás llegará a poseer un profundo espíritu de oración')";
    private String a65="insert into frases values ('Durante el día debemos mantener el contacto con Dios también mediante breves jaculatorias')";
    private String a66="insert into frases values ('Debemos procurar que el trabajo llegue a ser oración, y la oración trabajo; en definitiva debemos lograr que ambos confluyan')";
    private String a67="insert into frases values ('Recogimiento es reunir todas las fuerzas y concentrarlas en Dios')";
    private String a68="insert into frases values ('Quien se domina en el hablar, gusta y comprende la vida interior. El alma está siempre dispuesta a recibir gracias de oración mayores y más profundas (Cfr. T, 61)')";
    private String a69="insert into frases values ('Existimos para que el Dios eterno sea alabado y ensalzado, conocido y reconocido')";
    private String a70="insert into frases values ('Adorar, en el sentido más amplio, significa cumplir por amor la voluntad de Dios')";
    private String a71="insert into frases values ('Cuando Cristo se encontraba frente a acontecimientos importantes, se retiraba noches enteras para orar')";
    private String a72="insert into frases values ('La actitud básica de Cristo fue siempre la misma: Padre, no se haga mi voluntad sino la tuya')";
    private String a73="insert into frases values ('La oración es la mayor fuerza educativa en el cielo y en la tierra')";
    private String a74="insert into frases values ('Cierta vez, un sacerdote preguntó al Cura de Ars de dónde sacaba su sabiduría y a qué se debía que pudiera responder correctamente a todos los interrogantes que se planteaban. Mientras señalaba su reclinatorio, él respondió: Aquí está la fuente de mi sabiduría')";
    private String a75="insert into frases values ('Educar significa: acoger vida, despertar vida y transmitir vida')";
    private String a76="insert into frases values ('No hay nada más grande en la educación, que poder constatar que aquellos a los que he educado, han madurado y yo me he vuelto superfluo')";
    private String a77="insert into frases values ('¡Cuál es el ideal del educador?: ¡servicio desinteresado a la vida ajena! ')";
    private String a78="insert into frases values ('Si me fijo demasiado en el éxito y éste es mi único motivo, me equivocaré fácilmente')";
    private String a79="insert into frases values ('La esencia de la Virgen María era y es el servir desinteresadamente a la vida')";
    private String a80="insert into frases values ('En mi opinión, el respeto es más necesario aún que el amor')";
    private String a81="insert into frases values ('No malinterpretemos los signos de los tiempos. Debemos tener más en cuenta la individualidad, de lo contrario educamos masificadamente')";


            public static Conexion getInstance(Context con) {
        /**
         * use the application context as suggested by CommonsWare.
         * this will ensure that you dont accidentally leak an Activitys
         * context (see this article for more information:
         * http://android-developers.blogspot.nl/2009/01/avoiding-memory-leaks.html)
         */
        if (instancia == null) {
            instancia = new Conexion(con.getApplicationContext());
        }
        return instancia;
    }

    //llamada al constructor
    public Conexion(Context context) {
        /*En lugar de esto creo que se podria aumentar todos los campos en el getInstance y ademas en la creacion de la
        instancia dentro del getInstance
        ademas. Eso tal vez para cambiar la version o algo asi.*/
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Ejecutar creacion al iniciar la aplicacion por primera vez.
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creacion de tabla
        db.execSQL(tb1);
        //Insercion de Frases
        db.execSQL(a1);
        db.execSQL(a2);
        db.execSQL(a3);
        db.execSQL(a4);
        db.execSQL(a5);
        db.execSQL(a6);
        db.execSQL(a7);
        db.execSQL(a8);
        db.execSQL(a9);
        db.execSQL(a10);
        db.execSQL(a11);
        db.execSQL(a12);
        db.execSQL(a13);
        db.execSQL(a14);
        db.execSQL(a15);
        db.execSQL(a16);
        db.execSQL(a17);
        db.execSQL(a18);
        db.execSQL(a19);
        db.execSQL(a20);
        db.execSQL(a21);
        db.execSQL(a22);
        db.execSQL(a23);
        db.execSQL(a24);
        db.execSQL(a25);
        db.execSQL(a26);
        db.execSQL(a27);
        db.execSQL(a28);
        db.execSQL(a29);
        db.execSQL(a30);
        db.execSQL(a31);
        db.execSQL(a32);
        db.execSQL(a33);
        db.execSQL(a34);
        db.execSQL(a35);
        db.execSQL(a36);
        db.execSQL(a37);
        db.execSQL(a38);
        db.execSQL(a39);
        db.execSQL(a40);
        db.execSQL(a41);
        db.execSQL(a42);
        db.execSQL(a43);
        db.execSQL(a44);
        db.execSQL(a45);
        db.execSQL(a46);
        db.execSQL(a47);
        db.execSQL(a48);
        db.execSQL(a49);
        db.execSQL(a50);
        db.execSQL(a51);
        db.execSQL(a52);
        db.execSQL(a53);
        db.execSQL(a54);
        db.execSQL(a55);
        db.execSQL(a56);
        db.execSQL(a57);
        db.execSQL(a58);
        db.execSQL(a59);
        db.execSQL(a60);
        db.execSQL(a61);
        db.execSQL(a62);
        db.execSQL(a63);
        db.execSQL(a64);
        db.execSQL(a65);
        db.execSQL(a66);
        db.execSQL(a67);
        db.execSQL(a68);
        db.execSQL(a69);
        db.execSQL(a70);
        db.execSQL(a71);
        db.execSQL(a72);
        db.execSQL(a73);
        db.execSQL(a74);
        db.execSQL(a75);
        db.execSQL(a76);
        db.execSQL(a77);
        db.execSQL(a78);
        db.execSQL(a79);
        db.execSQL(a80);
        db.execSQL(a81);

        // db.execSQL(a3);
    }

    //ejecutar actualiacion
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
