home-work-1
===========

Innehåller tomma filer till inlämningen. Huvudet i filerna är inte korrekta utan
 anger endast vilken typ av klass det är. Behöver ni lägga till fler filer är 
det ok. Vill ni döpa om filer görs detta enklast via GUI klienten. 
Vid användning av shell kör mv kommandot.

Arbetsgång:

- [ ] Gör en fork av denna repo till din github användare.
- [ ] Skriv färdigt projektet (kom ihåg att göra en push ofta i fall det skulle hända något med koden).
- [ ] Fyll i logfilen eftersom du skriver projektet
    - Log-filen skrivs enligt:
        - Datum
        - Vad skall jag göra idag.
        - Vad är problemet?
        - Till nästa gång
- [ ] Readme-filen
     - Fyll i under rubrikerna nedan.
- [ ] När projektet är färdigt gör en sista push till din användare.
- [ ] Sista steget är att göra en pull-request till den här repo:n. Se till att göra den till din branch.


---


Inledning
---
En inlämning i programmering 2 på björknäsgymnasiet gjord av Simon Hornestedt te12 (Teknikprogrammet åk3)

Presentation av projektet/programmet
---
Spelet är ett RTS spel fast textbaserat. Det baseras på några grundregler inom brädspelet risk men är väldigt förenklat.
Spelet är lätt att vinna och väldigt obalanserat. 
Npc attackerar varje runda och gör det med sin största arme mot spelarens minsta. spelet körs till någon äger alla länder.

Genomförande
---
Detta finns i loggfilen som ligger i repon. har försökt dokumentera så mycket som möjligt där

Hur gick det?
---
Jag är nöjd med programmet utifrån vad jag hade för förväntningar inför detta men det är klart att det alltid finns saker att förbättra. 

Slutresultat/Analys/Diskussion
---
Det var en utmaning att programmera detta men jag måste säga att jag lärt mig mycket.
Det var mycket nytt med abstrakta klasser till en början men det gick bra att lära sig att använde de eftersom programmet utvecklades. 
Jag försökte hålla all kodning så allmän som möjligt men såklart har det blivit en del hårdkodning tillslut för att få det att fungera som jag ville.

- Buggar: npcn försöker ibland att använda spelarens pengar men misslyckas. Detta sker ibland när den slumpar ett land som spelaren äger. 
- Förbättringar: man hade kunnat göra en separat klass som hette land som höll reda på sin egen panel och sin arme tror att  det had förenklat mycket då skulle man dessutom kunna använda fler spelare än detta är hårdkodat för
- Övrigt: i övrigt är jag nöjd med min prestation och hoppas att jag även lyckats med dokumenteringen
