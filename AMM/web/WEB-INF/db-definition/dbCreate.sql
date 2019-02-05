/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  federicadessi
 * Created: 17-set-2018
 */

drop table utente;
drop table notizia;
drop table commenti;

create table utente (
    id serial primary key,
    nome varchar(100),
    cognome varchar(100),
    username varchar(100) not null,
    email varchar(100) not null,
    tipologia varchar(100),
    password varchar(100) not null,
    img varchar(100)
);

create table notizia(
    id serial primary key,
    titolo varchar(200) not null,
    contenuto varchar(2000), 
    didascalia varchar(200), 
    img varchar(100),
    autore bigint unsigned references utente(id) on delete no action
                                                 on update cascade,
    categoria varchar(50),
    dataPubblicazione date
);

create table commenti(
    id serial primary key,
    idutente bigint unsigned references utente(id) on delete no action 
                                                    on update cascade,
    idnotizia bigint unsigned references notizia(id) on delete no action 
                                                      on update cascade, 
    testo varchar(2000),
    dataCommento date
);


insert into utente values(default, 'Federica', 'Dessì', 'f.dessi025','f.dessi025@gmail.com', 'autore','12345', 'user.png<');
insert into utente values(default, 'Andrea', 'Visca', 'a.visca','a.visca@gmail.com', 'lettore','12345', 'user.png<');
insert into utente values(default, 'Patrizio', 'Marras', 'p.marras','p.marras@gmail.com', 'ospite','12345', ''user.png<);

insert into notizia values(default, "Scrive per sbaglio 'Incluso nel prezzo' su una pagina del sito : licenziato dipendente Apple", "CUPERTINO Non l'ho fatto apposta, mi  scappato!Sono queste le prime parole pronunciate dall'ormai ex dipendente della Apple,   John Honest, dopo aver aggiunto per sbaglio, mentre compilava  la descrizione di un prodotto sul sito,   una frase che mai ci si sarebbe immaginato di leggere  associata a un prodotto della mela: Included in the price.   Il ragazzo, intervistato mentre friggeva patatine nella cucina di un McDonald's nella periferia di Detroit,   ha comunque mostrato di non serbare rancore verso i suoi ex colleghi di lavoro: Per Natale ho anche mandato loro in regalo decine di Samsung Galaxy S7.", 'Licenziato dipendente Apple','apple-logo.gif', '0','Apple', CURDATE());
insert into notizia values(default, 'Facebook, Mark Zuckerberg rimuove i senatori USA dagli amici', "WASHINGTON  'È in momenti come questi che avrei preferito rubare l'idea di Google Plus!' deve aver pensato  Mark Zuckerberg al cospetto del Congresso degli Stati Uniti per chiarire la posizione di Facebook nello scandalo Cambridge Analytica. Il CEO del social più famoso del mondo, in un elegante completo giacca, cravatta e ciabatte da doccia, ha dovuto rispondere soprattutto  al modo in cui si sia entrati in possesso dei dati di 87 milioni di persone e di come siano stati utilizzati: 'Be, ce li hanno dati loro spontaneamente, chi pensava che volessero tenerli nascosti?'", 'Mark Zuckerberg davanti al Senato','zuck-senato.jpg', '1','Facebook', CURDATE());
insert into notizia values(default, "Lavoro, Amazon lancia la formula All You Can Work: stipendio fisso e lavori finché puoi", "STRAORDINA I nostri dipendenti sono entusiasti, sono queste le parole di Adolfa Stacanova, direttrice del personale di Amazon Italia e ideatrice di un'innovativa metodologia applicata al mondo del lavoro che ora sta spopolando nelle startup e nelle aziende di tutta Italia. Soddisfatti anche i sindacati, che hanno approvato  all'unanimità  questa nuova forma contrattuale che apporta un miglioramento considerevole delle condizioni del lavoratore rispetto al Jobs Act e pone l'Italia all'inseguimento dello standard cinese. Adesso il nuovo trend sembra aver contagiato anche altre aziende, tra cui la Slavery Srl, che promette di fare ancora di più: lo stipendio sarà infatti sostituito con dei Gratta e Vinci, che daranno ogni mese la possibilità agli impiegati di sognare a occhi aperti", 'All You Can Work Amazon' , 'o.451651.jpg', '1','Amazon', CURDATE());

select * from utente;