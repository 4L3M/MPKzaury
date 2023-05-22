

Sprawozdanie z realizacji projektu

Symulacja ruchu tramwajów



Autorzy:
Amelia Draga 272866
Konrad Grunt 123456	


Prowadzący:
mgr inż. Damian Mroziński

Przedmiot:
Programowanie obiektowe
Laboratorium




Spis treści

1.	Cel projektu		3
2.	Założenia projektowe	3
3.	Opis symulacji		3
                  Spis rysunków		7


1.	Cel projektu
Celem projektowanego systemu informatycznego jest symulacja poruszania się tramwajów w dużym mieście np. we Wrocławiu. Tramwaje poruszają się po określonych dla danej linii trasach, a na przystankach stają zgodnie z rozkładem jazdy. Niemniej jednak maszyny mogą ulegać awarii. Skutkuje to spóźnieniami oraz wstrzymaniem ruchu na trasie. Celem symulacji jest sporządzenie statystyk dotyczących awaryjności tramwajów oraz zliczenie łącznego czasu spóźnień. Na podstawie zebranych danych wybrana zostanie wybrana najmniej zawodna linia. 

2.	Założenia projektowe

Zgodnie z założeniami projektowymi w symulacji zostały zaimplementowane następując mechanizmy projektowania obiektowego:
o	klasy
o	hermetyzacja
o	dziedziczenie
o	kompozycja/agregacja0
o	polimorfizm

3.	Opis symulacji
Symulacja dotyczy awaryjności i spóźnień tramwajów. Jej wynikiem będą sumy spóźnień wszystkich tramwajów w danej chwili oraz ilość awarii pojazdów, również w danej chwili. 
Symulowany jest ruch tramwajów. Tramwaj ma określoną długość i numer linii. Poruszają się one trasą charakterystyczną dla danej linii. Pojazdy ulegają awariom powodującym ich zatrzymanie na trasie. Ruch w tym miejscu jest blokowany do momentu przyjazdu tramwaju naprawczego (serwisant), który albo naprawia usterkę na miejscu, albo holuje pojazd do najbliższej pętli. Co więcej, tramwaj ten będzie na bieżąco kontrolować tramwaje czy nie uległy awarii.

Jak wcześniej wspomniano, w symulacji występują dwa rodzaje tramwajów. To one są aktorami i podejmują decyzje dotyczące działania symulacji. Relacje pomiędzy nimi oraz to jakie zachowania mogą przejawiać prezentuje diagram przypadków użycia na Rysunku 1. 

 
Rysunek 1. Diagram przypadków użycia

Tramwaj w zajezdni, poprzez otrzymanie numeru linii, dostaje informację na temat trasy, po której może się poruszać. Następnie pojazd sprawdzając jakie numery linii przechowuje dany tor, kontroluje przejazd. Aby uniknąć kolizji na bieżąco analizuje on również dostępność pola tj. czy jest wolne czy nie. Na skrzyżowaniu dróg (zwrotnica) tramwaj pobiera informację na temat możliwości wjazdu na skrzyżowanie i kontynuowaniu przejazdu zgodnie ze swoją linią.

Kolejnymi obiektami symulacji są przystanki, pętle oraz zajezdnie. Tramwaj zatrzymuje się na przystanku i odjeżdża z niego o godzinie zgodnej z rozkładem jazdy. Pętla natomiast jest miejscem, gdzie tramwaj zmienia kierunek jazdy. Z niej również tramwaj wyjeżdża o określonej przez rozkład godzinie. W ciągu różnych pór dnia na liniach kursuje różna liczba tramwajów. W związku z tym zajezdnia stacjonuje pojazdy nie będące aktualnie w trasie. Ponadto nadaje ona wyjeżdzającemu tramwajowi numer linii, który będzie obsługiwał. W zajezdni przechowywane będą również tramwaje naprawcze. Niekiedy zajezdnia pełni rolę pętli – zawraca tramwaje oraz wypuszcza je na trasę zgodnie z rozkładem. Relacje pomiędzy tymi obiektami, w wybranym wycinku trwania symulacji przedstawia diagram obiektów znajdujący się na Rysunku 2.

Mapa reprezentuje duże miasto, typu Wrocław. Symulator wczytuje mapę z postaci tekstowej. Każdy element typu tor lub tramwaj oznaczony jest pojedynczym znakiem. Cechy szczególne obiektów, wymagające wczytania więcej niż jednego symbolu z mapy, znajdują się w osobnym pliku.
 
 
 
Rysunek 2. Diagram obiektów 
 
Spis rysunków

Rysunek 1. Diagram przypadków użycia	4
Rysunek 2. Diagram obiektów	6

