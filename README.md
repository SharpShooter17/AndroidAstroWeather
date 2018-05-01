# AndroidAstroWeather

Celem ćwiczenia jest zapoznanie się z następującymi zagadnieniami:
* Interfejs użytkownika bazujący na fragmentach.
* Komunikacja pomiędzy fragmentami i aktywnością.
* Dostosowanie interfejsu użytkownika do różnych ekranów.
Założenia:
1) Zadaniem aplikacji jest obliczanie i prezentacja informacji astronomicznych dotyczących
Słońca i Księżyca.
Informacje prezentowane przez aplikację to:
###### Dla Słońca:
* Wchód (czas i azymut).
* Zachód (czas i azymut).
* Zmierz i świt cywilny (czas).
###### Dla Księżyca:
* Wchód i zachód (czas).
* Najbliższy nów i pełnia (data).
* Faza księżyca (w procentach).
* Dzień miesiąca synodycznego.
3) Ponadto aplikacja powinna wyświetlać aktualny czas urządzenia (odświeżany co 1
sekundę) oraz lokalizację wprowadzoną przez użytkownika (długość i szerokość
geograficzną), dla której obliczane są w/w dane.
4) Informacje astronomiczne powinny być odświeżane co pewien czas, zdefiniowany przez
użytkownika w ustawieniach (np. co 15 minut).
5) Do obliczenia informacji astronomicznych można wykorzystać bibliotekę
AstroCalculator. Bibliotekę w formie pliku JAR można znaleźć pod adresem: http://
fiona.dmcs.pl/~pperek/pam_2015_2016/AstroCalculator_lib/astrocalculator.jar
Dokumentacja biblioteki znajduje się pod adresem: http://fiona.dmcs.pl/~pperek/
pam_2015_2016/AstroCalculator_lib/doc/index.html
6) Obliczone dane powinny być prezentowane w przejrzystej formie niezależnie od typu
urządzenia (telefon/tablet). W tym celu należy zaprojektować interfejs bazujący na co
najmniej dwóch fragmentach (1 – dla Słońca, 2 – dla Księżyca).
Układ fragmentów na ekranie powinien być zależny od jego orientacji i rozdzielczości.
Aplikacja powinna uwzględniać co najmniej 4 różne layouty (tablet/telefon, orientacja
pionowa/pozioma).
W układzie pionowym na telefonie fragmenty powinny być przewijane (w tym celu można
wykorzystać widok ViewPager). W przypadku tabletów wszystkie fragmenty mogą być
jednocześnie widoczne na ekranie.
7) W aplikacji powinno być dostępne menu, które umożliwi ustawienie:
* Lokalizacji (długość i szerokość geograficzna).
* Częstotliwości odświeżania danych astronomicznych (można w tym celu wykorzystać
Android Spinner adapter).
