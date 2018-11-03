package ua.com.motometer.android.ui.state

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.State

internal class StateMachineTest {

    @ParameterizedTest
    @MethodSource("parameters")
    fun changeState(currentState: State, action: Action, expectedState: State) {

        val result = currentState.changeState(action)

        assertThat(result).isEqualTo(expectedState)
    }

    companion object HomeTest {
        @JvmStatic
        fun parameters(): List<Any> {
            return listOf(
                    Arguments { arrayOf(AddRecord, Actions.Common.OpenMenu, Menu(AddRecord)) },
                    Arguments { arrayOf(AddRecord, Actions.Common.CloseMenu, Menu(AddRecord, false)) },
                    Arguments { arrayOf(AddRecord, Actions.Common.Back, Home) },
                    Arguments { arrayOf(AddRecord, Actions.Menu.Garage, Garage()) },
                    Arguments { arrayOf(AddRecord, Actions.Menu.Home, Home) },
                    Arguments { arrayOf(AddRecord, Actions.Menu.SignOut, SignOut) },
                    Arguments { arrayOf(Garage(true), Actions.Common.OpenMenu, Menu(Garage(true))) },
                    Arguments { arrayOf(Garage(true), Actions.Common.Back, Home) },
                    Arguments { arrayOf(Garage(true), Actions.Garage.Add, NewVehicle) },
                    Arguments { arrayOf(Garage(true), Actions.Garage.Empty, Garage(true)) },
                    Arguments { arrayOf(Garage(true), Actions.Menu.Garage, Garage(true)) },
                    Arguments { arrayOf(NewVehicle, Actions.Common.Back, Garage()) },
                    Arguments { arrayOf(NewVehicle, Actions.Garage.FinishCreate, NewVehicleCreated) },
                    Arguments { arrayOf(NewVehicle, Actions.Garage.Add, NewVehicle) },
                    Arguments { arrayOf(NewVehicle, Actions.Garage.Cancel, Garage()) },
                    Arguments { arrayOf(NewVehicle, Actions.Home.AddNewRecord, NewVehicle) },
                    Arguments { arrayOf(SignOut, Actions.Common.Back, SignOut) },
                    Arguments { arrayOf(VehicleDetails(10), Actions.Common.Back, Garage()) },
                    Arguments { arrayOf(Home, Actions.Common.OpenMenu, Menu(Home)) },
                    Arguments { arrayOf(Home, Actions.Common.Back, AppClosed) },
                    Arguments { arrayOf(Home, Actions.Home.AddNewRecord, AddRecord) },
                    Arguments { arrayOf(AppClosed, Actions.Home.AddNewRecord, AppClosed) },
                    Arguments { arrayOf(Garage(), Actions.Common.OpenMenu, Menu(Garage())) },
                    Arguments { arrayOf(Garage(), Actions.Common.Back, Home) },
                    Arguments { arrayOf(Garage(), Actions.Garage.Add, NewVehicle) },
                    Arguments { arrayOf(Garage(), Actions.Garage.Empty, Garage(true)) },
                    Arguments { arrayOf(Garage(), Actions.Home.AddNewRecord, Garage()) }
            )
        }
    }
}