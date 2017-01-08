package co.uk.mybddapp.stepdefs;

import co.uk.mybddapp.screens.HomeScreen;
import co.uk.mybddapp.screens.SearchScreen;
import co.uk.mybddapp.utils.BrowserFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sasikala jayavel on 5/9/16.
 */
public abstract class AbstractSteps {
    @Autowired
    public BrowserFactory browserFactory;

    @Autowired
    public HomeScreen homeScreen;

    @Autowired
    public SearchScreen searchScreen;




}
