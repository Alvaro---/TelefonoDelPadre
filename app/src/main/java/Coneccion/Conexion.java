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
/*            private String a3=insert into frases values (' "¡Sí, Padre, sí! que siempre se haga tu Voluntad, si me trae alegría, sufrimiento o dolor" (T).
            private String a3=insert into frases values (' "Haz que el espíritu de servicialidad penetre profundamente en mis sentimientos de vida" (T).
            private String a3=insert into frases values (' "La cruz bendice al mundo" (T).
            private String a3=insert into frases values (' "Con María alegres por la esperanza" (T).
            private String a3=insert into frases values (' "¡La voluntad del Padre Celestial sobre todas las cosas!" (T).
            private String a3=insert into frases values (' "Rezo para que en Ud. se realice la voluntad de Dios" (T).
            private String a3=insert into frases values (' "Que viva en mí el alma de María, para que cante en mi el Magnificat" (T).
            private String a3=insert into frases values (' "Hazme ser un sacrificio de la misericordia" (T).
            private String a3=insert into frases values (' "¡La soledad es fecunda!" (T)
            private String a3=insert into frases values (' "En las manos del Padre hacia el hogar" (T).
            private String a3=insert into frases values (' "¡Bienaventurados los de corazón puro porque verán a Dios!" (T)
            private String a3=insert into frases values (' "¡Hazme ser sol para todos!" (T)
            private String a3=insert into frases values (' "Permanezca Ud. alerta para todo lo bueno y busque en todo una sana medida" (T).
            private String a3=insert into frases values (' "El Ángel del Señor anunció a María..."(T).
            private String a3=insert into frases values (' "Bueno es todo lo que Él hace" (T).
            private String a3=insert into frases values (' "¡Siempre de nuevo tengo que leer en el corazón de María, pues ningún otro libro aquí en la tierra nos guía más rápido hacia el cielo!" (T)
            private String a3=insert into frases values (' "Yo vengo del Amor, vivo del Amor y vuelvo al Amor..."(T).
            private String a3=insert into frases values (' "La semilla tiene que ser enterrada en la tierra y desaparecer, entonces trae mucho fruto" (T).
            private String a3=insert into frases values (' "El verdadero amor no se siente nunca abandonado" (T).
            private String a3=insert into frases values (' "¡Dios es un Dios de alegría y de paz!" (T)
            private String a3=insert into frases values (' "Hazme Padre ser un milagro de misericordia, pues soy débil y pequeño" (T).
            private String a3=insert into frases values (' "La fuerza del Altísimo te cubrirá con su sombra" (T).
            private String a3=insert into frases values (' "Haga feliz a cuantas personas sea posible..." (T).
            private String a3=insert into frases values (' "¡No os preocupéis angustiosamente! La mayor preocupación es ser infinitamente despreocupados" (T).
            private String a3=insert into frases values (' "¡Quedamos en eso! ¡Permanecemos fieles!" (T)
            private String a3=insert into frases values (' "...sea para muchas personas un indicador de camino, y portador de luz y de alegría" (T).
            private String a3=insert into frases values (' "El que mantiene siempre abiertos el corazón y los sentidos para lo que agrada a Dios, permanece joven hasta la edad avanzada, porque nunca le falta la fuerza del amor" (T).
            private String a3=insert into frases values (' "El amor es el poder más grande" (T).
            private String a3=insert into frases values (' "Lleve Ud. su cruz tranquilo, humilde, valiente. ¡Así ayuda Ud. a salvar el mundo!"
            private String a3=insert into frases values (' "Mi destino descansa en las manos del Padre" (T).
            private String a3=insert into frases values (' "¡Qué pocos católicos han experimentado real y vitalmente que "Dios es mi Padre!" (D, 14).
            private String a3=insert into frases values (' "Si no estoy unido al Dios personal, la vida nos enfermará. Necesitamos descansar en Dios" (D, 14).
            private String a3=insert into frases values (' "Lo que hoy salva al mundo es un gran desprendimiento, es el espíritu de sacrificio, y éste debe nacer del amor filial. El profundo amor filial enciende un desprendimiento increíble" (D, 18).
            private String a3=insert into frases values (' "Estar en Cristo Jesús, según Pablo, es sufrir con Cristo, morir y ser sepultado con Él, resucitar y vivir en Él, ser transfigurado y reinar con Él, participar de Él, estar incorporado y configurado a Él (cf. Rom 6,3-5; 6,11; 8,17; 2 Cor 5, 15)" (D, 26).
            private String a3=insert into frases values (' "La santidad es la configuración en Cristo, y Cristo ha hecho suya y ha conservado a través de toda su vida la actitud filial ante el Padre" (D, 31).
            private String a3=insert into frases values (' "Cuando el Espíritu Santo actúa en el alma de un modo profundamente eficaz, entonces el hijo tiene un solo ideal: cumplir el deseo del Padre, vivir en conformidad con la voluntad de Dios" (D, 44).
            private String a3=insert into frases values (' "Cumplir sólo lo que desea el Padre y cultivar el espíritu de hijos durante toda la vida, es algo tan maravillosamente grande, supera en tal forma el poder humano, que debemos decir: sin el Espíritu Santo esto es absolutamente imposible" (D, 45).
            private String a3=insert into frases values (' "Cuanto más desvalidos e indignos nos sintamos para recibir tales dones, tanto más abundantemente nos serán regalados" (D, 47).
            private String a3=insert into frases values (' "El camino mariano no es meramente un camino más, sino un camino excelente para hacernos hijos del Padre celestial" (D, 57).
            private String a3=insert into frases values (' "La Santísima Virgen es el modelo de la auténtica filialidad. Ella la aprendió del Hijo unigénito de Dios" (D, 62).
            private String a3=insert into frases values (' "Toda la vida de la Santísima Virgen es una concretización de la voluntad de Dios, una constante y absoluta entrega al deseo y a la voluntad del Padre" (D, 63).
            private String a3=insert into frases values (' "A la luz de la fe, veo la mano del Padre aún en los golpes del destino" (D, 81).
            private String a3=insert into frases values (' "Jesús recalca con frecuencia que Dios Padre se preocupa paternalmente de cada hombre, incluso hasta de las pequeñeces más insignificantes" (D, 82).
            private String a3=insert into frases values (' "Cuanto más incondicionalmente confíe en el Padre, tanto más incondicionalmente me manifestaré su amor paternal" (D, 83).
            private String a3=insert into frases values (' "Nuestra preocupación más grande debería ser estar infinitamente despreocupados en cada segundo, no por negligencia, sino porque confiamos en Dios" (D, 83).
            private String a3=insert into frases values (' "Los santos se han hecho santos desde el momento en que comenzaron a amar. Y esta verdad es correlativa a aquella otra: han comenzado a amar cuando se creyeron, se supieron y se sintieron amados" (D, 89).
            private String a3=insert into frases values (' "En la expresión "Abba, querido Padre", se expresa un cobijamiento, una tranquilidad y una paz sumamente profundas" (D, 98).
            private String a3=insert into frases values (' "Lo que nos fascina en el niño es especialmente su simplicidad, su rectitud, su sencillez" (D, 101).
            private String a3=insert into frases values (' ""Me glorío de mi debilidad, porque mediante ella se manifiesta la fuerza de Cristo en mí" (2 Cor 12,6), la fuerza de Cristo, que me impulsa, en ultimo término, hacia los brazos del Padre misericordioso" (D, 118).
            private String a3=insert into frases values (' "El hombre filial y humilde alcanzará de Dios todo cuanto quiera. Así lo dicen los santos, así lo dice también la Sagrada Escritura: "ensalza a los pequeños" (Lc 1,52)" (D, 120).
            private String a3=insert into frases values (' "Para medir nuestra vida cristiana sólo necesitamos fijarnos cómo rezamos. ¡Con agrado, con alegría, con profundidad, constantemente? La respuesta nos da la idea de la autenticidad de nuestra cristianismo, de nuestra fe cristiana" (T, 16).
            private String a3=insert into frases values (' "Dios debe tocar nuestra corazón para que realmente aprendamos a orar" (T, 33).
            private String a3=insert into frases values (' Quien no se domina en el hablar, jamás llegará a poseer un profundo espíritu de oración" (Cfr. T, 39).
            private String a3=insert into frases values (' "Durante el día debemos mantener el contacto con Dios también mediante breves jaculatorias" (T, 52).
            private String a3=insert into frases values (' "Debemos procurar que el trabajo llegue a ser oración, y la oración trabajo; en definitiva debemos lograr que ambos confluyan" (T, 52).
            private String a3=insert into frases values (' "Recogimiento es reunir todas las fuerzas y concentrarlas en Dios" (T, 57).
            private String a3=insert into frases values (' Quien se domina en el hablar, gusta y comprende la vida interior. El alma está siempre dispuesta a recibir gracias de oración mayores y más profundas (Cfr. T, 61).
            private String a3=insert into frases values (' "Existimos para que el Dios eterno sea alabado y ensalzado, conocido y reconocido" (T, 73).
            private String a3=insert into frases values (' "Adorar, en el sentido más amplio, significa cumplir por amor la voluntad de Dios" (T, 79).
            private String a3=insert into frases values (' "Cuando Cristo se encontraba frente a acontecimientos importantes, se retiraba noches enteras para orar" (T, 99).
            private String a3=insert into frases values (' "La actitud básica de Cristo fue siempre la misma: "Padre, no se haga mi voluntad sino la tuya"" (T, 106).
            private String a3=insert into frases values (' "La oración es la mayor fuerza educativa en el cielo y en la tierra" (T, 115).
            private String a3=insert into frases values (' "Cierta vez, un sacerdote preguntó al Cura de Ars de dónde sacaba su sabiduría y a qué se debía que pudiera responder correctamente a todos los interrogantes que se planteaban. Mientras señalaba su reclinatorio, él respondió: "Aquí está la fuente de mi sabiduría"" (T, 118).
            private String a3=insert into frases values (' "Educar significa: acoger vida, despertar vida y transmitir vida" (P, 27).
            private String a3=insert into frases values (' "No hay nada más grande en la educación, que poder constatar que aquellos a los que he educado, han madurado y yo me he vuelto superfluo" (P, 29).
            private String a3=insert into frases values (' "¡Cuál es el ideal del educador?: ¡servicio desinteresado a la vida ajena! "(Cfr. P, 29).
            private String a3=insert into frases values (' "Si me fijo demasiado en el éxito y éste es mi único motivo, me equivocaré fácilmente" (P, 108).
            private String a3=insert into frases values (' "La esencia de la Virgen María era y es el servir desinteresadamente a la vida" (P, 118).
            private String a3=insert into frases values (' "En mi opinión, el respeto es más necesario aún que el amor" (P, 119).
            private String a3=insert into frases values (' "No malinterpretemos los signos de los tiempos. Debemos tener más en cuenta la individualidad, de lo contrario educamos masificadamente" (P, 123).
*/



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
       // db.execSQL(a3);
    }

    //ejecutar actualiacion
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
