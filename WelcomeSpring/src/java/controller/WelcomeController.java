
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.WelcomeService;

/**
 *
 * @author Sophie
 */
public class WelcomeController extends SimpleFormController {

    private WelcomeService welcomeService;
    
    public WelcomeController() {

        setCommandClass(Name.class);
        setCommandName("name");
        setSuccessView("welcomeView");
        setFormView("nameView");
    }
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        Name name = (Name) command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        mv.addObject("welcomeMessage", welcomeService.sayWelcome(name.getValue()));
        return mv;
    }
    
    public void setWelcomeService(WelcomeService welcomeService){
        this.welcomeService = welcomeService;
    }
  
}
