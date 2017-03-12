package TemperatuurService;

import com.sun.xml.internal.ws.wsdl.writer.document.*;

import javax.jws.WebService;
import java.text.DecimalFormat;

@WebService( endpointInterface= "TemperatuurService.WSInterface")
public class TemperatuurServiceImpl implements WSInterface {

    @Override
    public Response berekenTemperatuur(Request request) throws Fault_Exception{
        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();




        try {

            //
            // De volgende reeks van "if-statements" "berekend" de temperatuur  van de meegegeven tijd en locatie.
            // De enige locaties die deze code ondersteunen zijn Utrecht, Barcelona en New York
            //
            double locationMultiplier;
            double timeMultiplier;

            if (request.getLocatie().equals("Utrecht")) {
                locationMultiplier = 1.0;
                if (request.getTijd().getMonth() == 12 || request.getTijd().getMonth() == 1 || request.getTijd().getMonth() == 2) { //winter
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = -5.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 0.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 6.0;
                    } else { // s'avonds
                        timeMultiplier = 2.0;
                    }
                } else if (request.getTijd().getMonth() == 3 || request.getTijd().getMonth() == 4 || request.getTijd().getMonth() == 5) { //lente
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 5.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 9.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 15.5;
                    } else { // s'avonds
                        timeMultiplier = 11.0;
                    }
                } else if (request.getTijd().getMonth() == 6 || request.getTijd().getMonth() == 7 || request.getTijd().getMonth() == 8) { //zomer
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 17.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 23.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 27.5;
                    } else { // s'avonds
                        timeMultiplier = 20.0;
                    }
                } else { //herfst
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 10.5;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 14.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 17.0;
                    } else { // s'avonds
                        timeMultiplier = 12.5;
                    }
                }

                DecimalFormat df = new DecimalFormat("#.##");

                double result = locationMultiplier * timeMultiplier;

                response.setResult("Het is " + df.format(result) + "°C in " + request.getLocatie());
            } else if (request.getLocatie().equals("Barcelona")) {
                locationMultiplier = 1.3;
                if (request.getTijd().getMonth() == 12 || request.getTijd().getMonth() == 1 || request.getTijd().getMonth() == 2) { //winter
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 3.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 4.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 8.0;
                    } else { // s'avonds
                        timeMultiplier = 5.0;
                    }
                } else if (request.getTijd().getMonth() == 3 || request.getTijd().getMonth() == 4 || request.getTijd().getMonth() == 5) { //lente
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 5.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 9.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 15.0;
                    } else { // s'avonds
                        timeMultiplier = 12.0;
                    }
                } else if (request.getTijd().getMonth() == 6 || request.getTijd().getMonth() == 7 || request.getTijd().getMonth() == 8) { //zomer
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 17.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 23.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 27.0;
                    } else { // s'avonds
                        timeMultiplier = 21.0;
                    }
                } else { //herfst
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 11.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 15.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 17.5;
                    } else { // s'avonds
                        timeMultiplier = 14.0;
                    }
                }

                DecimalFormat df = new DecimalFormat("#.##");

                double result = locationMultiplier * timeMultiplier;

                response.setResult("Het is " + df.format(result) + "°C in " + request.getLocatie());
            } else if (request.getLocatie().equals("New York")) {
                locationMultiplier = 1.15;
                if (request.getTijd().getMonth() == 12 || request.getTijd().getMonth() == 1 || request.getTijd().getMonth() == 2) { //winter
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = -5.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = -1.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 6.0;
                    } else { // s'avonds
                        timeMultiplier = 2.0;
                    }
                } else if (request.getTijd().getMonth() == 3 || request.getTijd().getMonth() == 4 || request.getTijd().getMonth() == 5) { //lente
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 5.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 9.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 15.0;
                    } else { // s'avonds
                        timeMultiplier = 11.0;
                    }
                } else if (request.getTijd().getMonth() == 6 || request.getTijd().getMonth() == 7 || request.getTijd().getMonth() == 8) { //zomer
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 17.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 23.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 27.0;
                    } else { // s'avonds
                        timeMultiplier = 20.0;
                    }
                } else { //herfst
                    if (request.getTijd().getHour() >= 22 || request.getTijd().getHour() < 6) { //s'nachts
                        timeMultiplier = 10.0;
                    } else if (request.getTijd().getHour() >= 6 || request.getTijd().getHour() < 11) { // s'ochtends
                        timeMultiplier = 14.0;
                    } else if (request.getTijd().getHour() >= 11 || request.getTijd().getHour() < 16) { // s'middags
                        timeMultiplier = 17.0;
                    } else { // s'avonds
                        timeMultiplier = 13.0;
                    }
                }

                //
                // Hier wordt het antwoord afgerond op twee decimalen.
                //
                DecimalFormat df = new DecimalFormat("#.##");

                double result = locationMultiplier * timeMultiplier;

                response.setResult("Het is " + df.format(result) + "°C in " + request.getLocatie());
            } else {
                //
                // Mocht er een onbekende locatie worden ingevult, dan wordt er een foutmelding gegeven met: " De meegegeven locatie wordt niet ondersteund.".
                //

                response.setResult("De meegegeven locatie wordt niet ondersteund.");
            }
        } catch(RuntimeException e){
            Fault x = factory.createFault();
            x.setErrorCode((short) 1);
            x.setMessage("De tijd en de datum " + request.getTijd() + " zijn verkeerd ingevuld. Probeer het op de volgende manier in te vullen: CCYYMMDDThhmmss = 2001-10-26T21:32:52");
            Fault_Exception fault = new Fault_Exception("Er is iets mis gegaan met het invullen van de tijd en datum.", x);
            throw fault;
        }
        return response;
    }
}