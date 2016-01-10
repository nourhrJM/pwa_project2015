insert into NATIONALITE (INTITULE) values ('francaise');
insert into NATIONALITE (INTITULE) values ('americaine');
insert into NATIONALITE (INTITULE) values ('japonaise');
insert into NATIONALITE (INTITULE) values ('marocaine');
insert into NATIONALITE (INTITULE) values ('chinoise');
insert into NATIONALITE (INTITULE) values ('mexicaine');
insert into NATIONALITE (INTITULE) values ('sud-africaine');

insert into SITUATIONFAMILIALE (INTITULE) values ('celibataire');
insert into SITUATIONFAMILIALE (INTITULE) values ('marie(e)');
insert into SITUATIONFAMILIALE (INTITULE) values ('veuf(ve)');

insert into COMPETENCE (INTITULE, LEVEL) values ('java', 90);
insert into COMPETENCE (INTITULE, LEVEL) values ('c++', 70);
insert into COMPETENCE (INTITULE, LEVEL) values ('uml', 10);
insert into COMPETENCE (INTITULE, LEVEL) values ('bureautique', 100);
insert into COMPETENCE (INTITULE, LEVEL) values ('dessin', 80);
insert into COMPETENCE (INTITULE, LEVEL) values ('marketing', 0);
insert into COMPETENCE (INTITULE, LEVEL) values ('spring', 50);
insert into COMPETENCE (INTITULE, LEVEL) values ('commerce', 0);
insert into COMPETENCE (INTITULE, LEVEL) values ('jee', 80);
insert into COMPETENCE (INTITULE, LEVEL) values ('java script', 50);
insert into COMPETENCE (INTITULE, LEVEL) values ('vente', 10);

insert into CONTRAT (INTITULE) values ('cdi');
insert into CONTRAT (INTITULE) values ('cdd');
insert into CONTRAT (INTITULE) values ('stage');
insert into CONTRAT (INTITULE) values ('interim');
insert into CONTRAT (INTITULE) values ('alternance');

insert into ETAT (INTITULE) values ('acceptee');
insert into ETAT (INTITULE) values ('refusee');
insert into ETAT (INTITULE) values ('en cours');

insert into LANGUE (INTITULE) values ('anglais');
insert into LANGUE (INTITULE) values ('allemand');
insert into LANGUE (INTITULE) values ('espagnol');
insert into LANGUE (INTITULE) values ('japonais');
insert into LANGUE (INTITULE) values ('chinois');
insert into LANGUE (INTITULE) values ('francais');

insert into MOBILITE (INTITULE) values ('nationale');
insert into MOBILITE (INTITULE) values ('internationale');
insert into MOBILITE (INTITULE) values ('regionale');

insert into SALAIRE (INTITULE) values ('moins de 30k');
insert into SALAIRE (INTITULE) values ('entre 30k et 35k');
insert into SALAIRE (INTITULE) values ('entre 35k et 40k');
insert into SALAIRE (INTITULE) values ('entre 40k et 45k');
insert into SALAIRE (INTITULE) values ('entre 45k et 50k');
insert into SALAIRE (INTITULE) values ('plus de 50k');

insert into SECTEUR (INTITULE) values ('Informatique');
insert into SECTEUR (INTITULE) values ('Art - Design');
insert into SECTEUR (INTITULE) values ('Audit - Conseil');
insert into SECTEUR (INTITULE) values ('Audiovisuel - Spectacle');
insert into SECTEUR (INTITULE) values ('Automobile');
insert into SECTEUR (INTITULE) values ('Banque - Assurance');
insert into SECTEUR (INTITULE) values ('BTP - Architecture');
insert into SECTEUR (INTITULE) values ('Agriculture');
insert into SECTEUR (INTITULE) values ('Sante');
insert into SECTEUR (INTITULE) values ('Chimie - Pharmacie');


INSERT INTO CANDIDAT (NOM, PRENOM, EMAIL, TEL, ADRESSE, LOGIN, PASSWORD )
	VALUES ('Test', 'Test', 'test.test@gmail.com', '011111111111', '149 Route 64 Ponte Vedra Beach, FL 32082 USA', 'test', 'test');
INSERT INTO CANDIDAT (NOM, PRENOM, EMAIL, TEL, ADRESSE, LOGIN, PASSWORD)
	VALUES ('Mickaël', 'Christian', 'christian.mickael@gmail.com', '0716151833', '149 Route 64 Ponte Vedra Beach, FL 32082 USA', 'christian', 'mickael');
INSERT INTO CANDIDAT (NOM, PRENOM, EMAIL, TEL, ADRESSE, LOGIN, PASSWORD)
	VALUES ('Raymonde', 'Fanny', 'fraymonde@live.fr', '0698523499', '52 Berkshire Drive Teaneck, NJ 07666 USA', 'fanny', 'raymonde');
INSERT INTO CANDIDAT (NOM, PRENOM, EMAIL, TEL, ADRESSE, LOGIN, PASSWORD)
	VALUES ('Eloi', 'Donat', 'donat88@yahoo.fr', '0769877452', '586 4th Street North Boca Raton, FL 33428 USA', 'donat', 'eloi');
INSERT INTO CANDIDAT (NOM, PRENOM, EMAIL, TEL, ADRESSE, LOGIN, PASSWORD)
	VALUES ('Deodat', 'Suzanne', 'suziedeo@gmail.com', '0766997513', '27 College Street Milledgeville, GA 31061 USA', 'suzanne', 'deodat');
INSERT INTO CANDIDAT (NOM, PRENOM, EMAIL, TEL, ADRESSE, LOGIN, PASSWORD)
	VALUES ('Philippe ', 'Ghislaine', 'ghislaine_phil@outlook.com', '0615489773', '281 Roosevelt Avenue Romeoville, IL 60446 USA', 'ghislaine', 'philippe');
INSERT INTO CANDIDAT (NOM, PRENOM, EMAIL, TEL, ADRESSE, LOGIN, PASSWORD)
	VALUES ('Brice', 'Arianne', 'brice2nice@caramail.com', '0398784633', '935 Myrtle Avenue Savannah, GA 31404 USA', 'arianne', 'brice');

INSERT INTO ANNONCEUR (NOM, EMAIL, TEL, LOGIN, PASSWORD, SECTEUR_ID)
	VALUES ('Atos Nice', 'atos@nice.com', '0123456789', 'atos', 'atos', '1');
INSERT INTO ANNONCEUR (NOM, EMAIL, TEL, LOGIN, PASSWORD, SECTEUR_ID)
	VALUES ('BMW Paris', 'bmw@paris.fr', '0123456789', 'bmw', 'bmw', '5');
INSERT INTO ANNONCEUR (NOM, EMAIL, TEL, LOGIN, PASSWORD, SECTEUR_ID)
	VALUES ('TF1 France', 'ftv@france.fr', '0123456789', 'ftv', 'ftv', '4');
INSERT INTO ANNONCEUR (NOM, EMAIL, TEL, LOGIN, PASSWORD, SECTEUR_ID)
	VALUES ('Hopital du nord - St Etienne', 'hdn@etienne.fr', '0123456789', 'hdn', 'hdn', '9');
INSERT INTO ANNONCEUR (NOM, EMAIL, TEL, LOGIN, PASSWORD, SECTEUR_ID)
	VALUES ('CGI Lyon', 'cgi@lyon.fr', '', 'cgi', 'cgi', '1');
INSERT INTO ANNONCEUR (NOM, EMAIL, TEL, LOGIN, PASSWORD, SECTEUR_ID)
	VALUES ('Bayer Germany', 'bayer@germany.com', '0123456789', 'bayer', 'bayer', '10');
	
INSERT INTO RH (NOM, PRENOM, EMAIL, TEL, LOGIN, PASSWORD)
	VALUES ('Moulin', 'Jean', 'jean.moulin@gmail.com', '099999999', 'jean', 'moulin');
INSERT INTO RH (NOM, PRENOM, EMAIL, TEL, LOGIN, PASSWORD)
	VALUES ('Vador', 'Dark', 'dark.vador@live.fr', '088888888', 'dark', 'vador');
INSERT INTO RH (NOM, PRENOM, EMAIL, TEL, LOGIN, PASSWORD)
	VALUES ('Obama', 'Barack', 'baobama@yahoo.fr', '077777777', 'barack', 'obama');
INSERT INTO RH (NOM, PRENOM, EMAIL, TEL, LOGIN, PASSWORD)
	VALUES ('Wayne', 'Bruce', 'bruce.wayne@waynetech.com', '0666666666', 'bruce', 'wayne');
INSERT INTO RH (NOM, PRENOM, EMAIL, TEL, LOGIN, PASSWORD)
	VALUES ('Galaxy', 'Samsung', 'galaxy@samsung.com', '01111111111', 'samsung', 'galaxy');
INSERT INTO RH (NOM, PRENOM, EMAIL, TEL, LOGIN, PASSWORD)
	VALUES ('Sarkozy', 'Nicolas', 'darkozy@caramail.com', '033333333', 'nicolas', 'sarkozy');
INSERT INTO RH (NOM, PRENOM, EMAIL, TEL, LOGIN, PASSWORD)
	VALUES ('Bendari', 'Yassine', 'yassine.bendari@gmail.com', '000000', 'yassine', 'yassine');

INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Enveloppes de te bouquetins permission qu frissonner qu moustachus. He mats en cela saut poil vint sous.
Tacherai negation sol net musiques iii ils. Reveillez son ifs pic assassins mes citadelle agreerait annoncait.
Nid est miserables fit uns primeveres revolution frissonner instrument frisottent. Ils rangs art lui eau autre garde.
Ont instrument mal nid simplement tristement admiration condamnait. Ouvrent langage surpris touffes pu regarde sa.
Vie annoncait conquerir cotillons atteindra les alternent pas qui. Triste appela hordes car eue. Menue ronde ils berce que rit herbe.
Net toussent illumine eut allaient. Pu chemins te sa on aurions humains. Pouvons drapees cavites epouser en accourt relatif va.
Cette neuve oh rendu la le en. Vin somptueux but massacrer cet sacrifice flamboyer ifs parlaient.
Ah ah cartons mariage publics me tristes trimons maudite.',
		'atos-2016', 1, 1, 1, 1, 1);
		
INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Arsenaux persuada prennent arrivera on faudrait voitures ii. Fanatiques compagnies est gourmettes oui.
Avec face ca hors coin ah mine sort. Ah epouse furent delire le acheve poemes sa fosses il.
Agreerait aux ici comprends que employees. Bruits apprit delire va claire je.
Neuve eue ils notre fer leurs. Viendrait adjudants consumait vin dernieres son tiendrons gaillards.
Nid dut eclaireurs but pressaient par cherissait approchait admiration evidemment.
Hein asie suit cela quoi nos roc noir peu. Metres ifs voyons non lignes dehors mon rebord.
Un ca abris roche voici et foret wagon. Je ah prenons tendons marches propice.
On consentiez defilaient en condamnait fanatiques retrouvait manoeuvres. Sein sent eue cet toi mais cher.
Pris vont tres ou sent oh seul. Passa pu tu ii desir en petit. Avant gifle somme feu aides calme ils.
Avec vaut sans oui quoi sol avis.',
		'bmw-1-15', 1, 2, 2, 2, 2);
		
INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Exasperer fillettes tu cuirasses un battirent oh citadelle cependant.
Etendards du on gachettes superieur eperonnes.
Abondance cauchemar superieur firmament boulevard eu la te soufflent. Jet vieil adore babil geste son moi.
Charger il longues ah la mauvais en. Boue sort suis le mats vaut ah ca vous.
Bourreaux sacrifice peu mystiques corbeille aux camarades indicible sur net.
Ce agacent va brulees meriter en. Donc hein que ils chez meme aux ete.
Qu creerent premiere ca retablir en imberbes oh penetrer ennemies. Seule corps berce le du abris toute ponts.
Signe peu ras coups subit. Et cantines xv on kolbacks hataient etranges adjudant.
Connu nuits etais on la. Un exasperer boulevard detourner tu dernieres on tu printemps sentiment.
Ai en garde pente je prime desir on.',
		'tf1-2-2', 1, 3, 3, 3, 3);
		
INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Atteignait entrainait on petitement la hurlements.
Faite la salle va essor.
Apres trois je doute ah me piqua plein si. Signes tenait si en dormir dehors.
Eclatantes legerement republique ah tu la moustachus victorieux pu.
Et tu oh signalant pu tremblent entrerent troupeaux dentelles.
Ete par arrivera souvenir sanglees feerique oui derriere relevant.
Recluse courent nez prenons oui mineurs secouee desolee.',
		'hopital-9952', 1, 4, 4, 1, 4);
		
INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Prisonnier primeveres ne ou arriverent survivants comprendre qu.
Bas legerement etonnement nationales cimetieres clairieres mon remarquait.
Abondance attardent que age dentelles tot soufflent vie. Qui ere artilleurs les commandant est remarquait.
Trouvent pourquoi morceaux des fit rit couchent pauvrete. Il alternent accoudees degourdir ne qu du echangent.
La durcis lieues ca terres region disent freres. Heure voyez quand toute air sales que canif art.
Jeterent un tambours attentif et un pressent octogone semblait.',
		'cgi-dev-1516', 1, 5, 5, 2, 5);
		
INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Bonnet savoir bruits courir on oh qu. Son ils toi rouge pitie monde. Nous au cree sans ce.
Tout on peur ruer nous sous ah pile. Renferment prisonnier ils republique but enveloppes nul.
Hagarde je diables enlever eu ii eparses se. Contient sa donnerai profonde pourquoi fenetres sa ii traverse.
Couverts par car prudence vie embrassa reparler. Neige peu gifle sol mes nos jours.
Oh ii boulevards instrument entrainait se sa. Surprit pic attenua encourt ecarter seconde mur sur lui.
Promenade en au jugements direction ou. Vif porta selon grand bas par.
Sur nez employees prenaient ete demeurent fut firmament indicible. Humaines six ici gravures ces arrivera.
Victoire sifflent ignorant habitent nouvelle ont six ici dissiper. Un legerement etonnement diplomates me consentiez.',
		'bayer:bayer-1', 1, 1, 1, 3, 6);
		
INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Eue citadelle descendit dentelles seulement nid affection mur vit.
Grille filles moment ere nid. Chose ronde art navre les toi ornee.
Sol amertume debouche ans tenacite. Xv prendre de pu ou soldats futaies.
Retarde grandie oignons epaules sa etoffes piquees je. Divin elles la coups or qu va.
Jeu cuirasses oui construit oui gaillards echangent non fillettes.
Oh un plateau abattre enormes il faisans cavites sillons. Enfin tenez pu parmi sa or quels.
Havresac son bataille grimaces ont essaiera fatalite repondit fin pic.
Paraitre effarees ah le ah fusiller ou blanches humaines. Retreci nez ici travers naguere courbes.
Air lui mur arrachait ans neanmoins suspendue.
Ne petillent lanternes fabriques va sortaient inassouvi superieur si.
Escadrons dut courroies construit air entremise entourage feeriques.
Rougeatres iii prisonnier peu comprendre infiniment admiration habilement.
Baisse la ah succes tenait genoux.',
		'atos:dev-16', 1, 2, 2, 1, 1);
		
INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Enfin une des poing nos cette. Situation expliquer regiments toi certitude eue repousser degourdir.
Vie sur tristement car subitement ces boulevards descendons inattendus executeurs.
Ames chez fait sort coin des sol joue nez.
Avance eau douane mur savoir ordure dit altere.
Du il motif cette patre ah pieds route. Prudence profonde coupoles prennent roc pas precieux pourquoi.
Ennemies massacre triomphe les cavernes des six toi.
Je or devant blason palais et epouse sa atroce. Se on rendre ah sortit annees jusque jambes voyage.
Chantant traverse soutenir net campagne sur remettre. Demeurons cet six art toutefois resterait les.
Firmament sortaient net echauffer aux reprendre preferait eux.',
		'bmw-2-16', 1, 3, 3, 2, 2);
		
INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Du sous chez mess et. Coupoles cet vit fut qui mettions cavalier.
Galopade je pourquoi la execrent contient familles nouvelle tu si.
Etonnement son construits poussaient evidemment fit approchait.
Commence on cavernes il falaises tu ai. Foi mes paraitre defoncat repondit creerent.
Entrainait habilement nos ecouterent gouverneur des dut peu. Pentes eu en rouges je tirant repond me.
Humains couleur maigres bonjour ma tassent oh. As si affection entrerent qu bourreaux ne marechaux.
Ere rouge vie temps terre etale. Sans murs age mon tira nul elle aime.
Est petitement air artilleurs republique toi victorieux gouverneur vin. Quoi aux bete par fils dans idee vont.
Pas pere pont rien par ils doit. Emergent dissiper peu que feu encontre.
Culbutent il agreerait alternent il causaient miserable. Aux ton par nos votre selon brave.',
		'tf1-3-3', 1, 4, 4, 3, 3);
		
INSERT INTO OFFRE (DESCRIPTION, INTITULE, REFERENCE, ANNONCEUR_ID, CONTRAT_ID, MOBILITE_ID, SALAIRE_ID)
	VALUES (
'Corolles qu et interdit et loquaces imberbes commande kolbacks.
Premiers adjudant bouleaux ifs crispent encontre cherirai peu. Par peu admiration partageait mendiaient bas.
Feu minutes musique art trimons ils. Non cris mur poil epis lors peut soit.
Depenser toussent au en voitures et. Executeurs de cathedrale gourmettes va comprendre paraissait.
Lassitude viendrait ca du du me sentiment fabriques meconnais convertir.
Redoublait defilaient ma manoeuvres le ah ah. Pres cime fond une par bas.
Pourrai habiles dut retarde relatif jet ans battant blanche. Verdure par pendant qui quitter six fit morales piquees theatre.
La oh signes sortit sortes manque. Decharnees mendiaient boulevards dur sur inattendus eclatantes.
Connut canons bonnet les peu raison.
Avec la main asie on cuir tout oh ruer en. Qu on oh escadrons causaient orientaux au.
Ce philomene sonnaient as marechaux.',
		'hop:98756', 1, 5, 5, 1, 4);
		
INSERT INTO PROPOSITION(OFFRE_ID, CANDIDAT_ID, RH_ID) VALUES (1, 1, 1);
INSERT INTO PROPOSITION(OFFRE_ID, CANDIDAT_ID, RH_ID) VALUES (1, 2, 1);
INSERT INTO PROPOSITION(OFFRE_ID, CANDIDAT_ID, RH_ID) VALUES (2, 2, 2);
INSERT INTO PROPOSITION(OFFRE_ID, CANDIDAT_ID, RH_ID) VALUES (3, 3, 3);
INSERT INTO PROPOSITION(OFFRE_ID, CANDIDAT_ID, RH_ID) VALUES (3, 1, 3);
INSERT INTO PROPOSITION(OFFRE_ID, CANDIDAT_ID, RH_ID) VALUES (4, 4, 4);

INSERT INTO CANDIDATURE(OFFRE_ID, CANDIDAT_ID) VALUES (1, 1);
INSERT INTO CANDIDATURE(OFFRE_ID, CANDIDAT_ID) VALUES (2, 1);
INSERT INTO CANDIDATURE(OFFRE_ID, CANDIDAT_ID) VALUES (3, 1);
INSERT INTO CANDIDATURE(OFFRE_ID, CANDIDAT_ID) VALUES (1, 2);
INSERT INTO CANDIDATURE(OFFRE_ID, CANDIDAT_ID) VALUES (1, 3);
INSERT INTO CANDIDATURE(OFFRE_ID, CANDIDAT_ID) VALUES (3, 4);
INSERT INTO CANDIDATURE(OFFRE_ID, CANDIDAT_ID) VALUES (5, 5);
INSERT INTO CANDIDATURE(OFFRE_ID, CANDIDAT_ID) VALUES (6, 3);

insert into CANDIDAT_COMPETENCE(CANDIDAT_ID, COMPETENCE_ID) VALUES (1, 1);
insert into CANDIDAT_COMPETENCE(CANDIDAT_ID, COMPETENCE_ID) VALUES (1, 2); 
insert into CANDIDAT_COMPETENCE(CANDIDAT_ID, COMPETENCE_ID) VALUES (1, 3); 
insert into CANDIDAT_COMPETENCE(CANDIDAT_ID, COMPETENCE_ID) VALUES (1, 4); 
insert into CANDIDAT_COMPETENCE(CANDIDAT_ID, COMPETENCE_ID) VALUES (2, 1); 
insert into CANDIDAT_COMPETENCE(CANDIDAT_ID, COMPETENCE_ID) VALUES (3, 5); 
insert into CANDIDAT_COMPETENCE(CANDIDAT_ID, COMPETENCE_ID) VALUES (2, 7); 
insert into CANDIDAT_COMPETENCE(CANDIDAT_ID, COMPETENCE_ID) VALUES (2, 3); 
insert into CANDIDAT_COMPETENCE(CANDIDAT_ID, COMPETENCE_ID) VALUES (5, 1);

insert into CANDIDAT_LANGUE(CANDIDAT_ID, LANGUE_ID) VALUES (1, 1);
insert into CANDIDAT_LANGUE(CANDIDAT_ID, LANGUE_ID) VALUES (1, 2);
insert into CANDIDAT_LANGUE(CANDIDAT_ID, LANGUE_ID) VALUES (1, 6);
insert into CANDIDAT_LANGUE(CANDIDAT_ID, LANGUE_ID) VALUES (2, 1);
insert into CANDIDAT_LANGUE(CANDIDAT_ID, LANGUE_ID) VALUES (2, 2);
insert into CANDIDAT_LANGUE(CANDIDAT_ID, LANGUE_ID) VALUES (3, 1);
insert into CANDIDAT_LANGUE(CANDIDAT_ID, LANGUE_ID) VALUES (4, 4);
insert into CANDIDAT_LANGUE(CANDIDAT_ID, LANGUE_ID) VALUES (3, 5);
insert into CANDIDAT_LANGUE(CANDIDAT_ID, LANGUE_ID) VALUES (6, 3);

insert into FORMATION(CANDIDAT_ID, DATE_DEBUT, DATE_FIN, DESCRIPTION) VALUES (1, '2011', '2013',
'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

insert into FORMATION(CANDIDAT_ID, DATE_DEBUT, DATE_FIN, DESCRIPTION) VALUES (1, '2013', '2015', 
'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

insert into FORMATION(CANDIDAT_ID, DATE_DEBUT, DATE_FIN, DESCRIPTION) VALUES (2, '2009', '2008',
'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

insert into FORMATION(CANDIDAT_ID, DATE_DEBUT, DATE_FIN, DESCRIPTION) VALUES (4, '2014', '2015',
'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

insert into FORMATION(CANDIDAT_ID, DATE_DEBUT, DATE_FIN, DESCRIPTION) VALUES (6, '2007', '2006',
'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');