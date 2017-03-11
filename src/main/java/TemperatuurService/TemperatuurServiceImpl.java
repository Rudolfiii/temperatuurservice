package TemperatuurService;

import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DecimalFormat;

@WebService( endpointInterface= "TemperatuurService.WSInterface")
public class TemperatuurServiceImpl implements WSInterface {

    @Override
    public Response berekenTemperatuur(Request request) {
        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();


        double locationMultiplier = 0;
        double timeMultiplier = 0;

        if (request.getLocatie().equals("Utrecht")){
            locationMultiplier = 1.0;
            if (request.getTijd().getMonth() == 12 || request.getTijd().getMonth() == 1 || request.getTijd().getMonth() == 2){ //winter
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = -5.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 0.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 6.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 2.0;
                }
            }
            else if (request.getTijd().getMonth() == 3 || request.getTijd().getMonth() == 4 || request.getTijd().getMonth() == 5){ //lente
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 5.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 9.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 15.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 11.0;
                }
            }
            else if (request.getTijd().getMonth() == 6 || request.getTijd().getMonth() == 7 || request.getTijd().getMonth() == 8){ //zomer
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 17.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 23.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 27.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 20.0;
                }
            }
            else if (request.getTijd().getMonth() == 9 || request.getTijd().getMonth() == 10 || request.getTijd().getMonth() == 11){ //herfst
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 10.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 14.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 17.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 13.0;
                }
            }

            double result = locationMultiplier * timeMultiplier;
            response.setResult("Het is " + result + "°C in "+ request.getLocatie());
        }

        else if (request.getLocatie().equals("Barcelona")){
            locationMultiplier = 1.3;
            if (request.getTijd().getMonth() == 12 || request.getTijd().getMonth() == 1 || request.getTijd().getMonth() == 2){ //winter
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 3.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 4.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 8.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 5.0;
                }
            }
            else if (request.getTijd().getMonth() == 3 || request.getTijd().getMonth() == 4 || request.getTijd().getMonth() == 5){ //lente
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 5.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 9.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 15.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 11.0;
                }
            }
            else if (request.getTijd().getMonth() == 6 || request.getTijd().getMonth() == 7 || request.getTijd().getMonth() == 8){ //zomer
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 17.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 23.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 27.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 20.0;
                }
            }
            else if (request.getTijd().getMonth() == 9 || request.getTijd().getMonth() == 10 || request.getTijd().getMonth() == 11){ //herfst
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 10.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 14.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 17.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 13.0;
                }
            }

            double result = locationMultiplier * timeMultiplier;
            response.setResult("Het is " + result + "°C in "+ request.getLocatie());
        }

        else         if (request.getLocatie().equals("New York")){
            locationMultiplier = 1.15;
            if (request.getTijd().getMonth() == 12 || request.getTijd().getMonth() == 1 || request.getTijd().getMonth() == 2){ //winter
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = -5.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = -1.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 6.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 2.0;
                }
            }
            else if (request.getTijd().getMonth() == 3 || request.getTijd().getMonth() == 4 || request.getTijd().getMonth() == 5){ //lente
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 5.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 9.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 15.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 11.0;
                }
            }
            else if (request.getTijd().getMonth() == 6 || request.getTijd().getMonth() == 7 || request.getTijd().getMonth() == 8){ //zomer
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 17.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 23.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 27.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 20.0;
                }
            }
            else if (request.getTijd().getMonth() == 9 || request.getTijd().getMonth() == 10 || request.getTijd().getMonth() == 11){ //herfst
                if (request.getTijd().getHour() >= 22 ||  request.getTijd().getHour() < 6 ){ //s'nachts
                    timeMultiplier = 10.0;
                }
                if (request.getTijd().getHour() >= 6 ||  request.getTijd().getHour() < 11 ){ // s'ochtends
                    timeMultiplier = 14.0;
                }
                if (request.getTijd().getHour() >= 11 ||  request.getTijd().getHour() < 16 ){ // s'middags
                    timeMultiplier = 17.0;
                }
                if (request.getTijd().getHour() >= 16 ||  request.getTijd().getHour() < 22 ){ // s'avonds
                    timeMultiplier = 13.0;
                }
            }

            DecimalFormat df = new DecimalFormat("#.##");

            double result = locationMultiplier * timeMultiplier;

            response.setResult("Het is " + df.format(result) + "°C in "+ request.getLocatie());
        }
        else {
            response.setResult("De meegegeven locatie wordt niet ondersteund");
        }
        return response;
    }
}