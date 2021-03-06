package com.badoo.ribs.samples.comms_nodes.rib.greeting

import com.badoo.ribs.clienthelper.connector.Connectable
import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.customisation.RibCustomisation
import com.badoo.ribs.samples.comms_nodes.rib.greeting.Greeting.Input
import com.badoo.ribs.samples.comms_nodes.rib.greeting.Greeting.Output
import com.badoo.ribs.samples.comms_nodes.rib.language_selector.Language

interface Greeting : Rib, Connectable<Input, Output> {

    interface Dependency

    sealed class Input {
        data class UpdateGreeting(val selectedIndex: Int) : Input()
    }

    sealed class Output {
        data class AvailableLanguagesDisplayed(val currentLanguage: Language) : Output()
    }

    class Customisation(
        val viewFactory: GreetingView.Factory = GreetingViewImpl.Factory()
    ) : RibCustomisation
}
