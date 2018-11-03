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
                    Arguments { arrayOf(EmptyGarage, Actions.Common.OpenMenu, Menu(EmptyGarage)) },
                    Arguments { arrayOf(EmptyGarage, Actions.Common.Back, Home) },
                    Arguments { arrayOf(EmptyGarage, Actions.Garage.Add, NewVehicle) },
                    Arguments { arrayOf(EmptyGarage, Actions.Garage.Empty, EmptyGarage) },
                    Arguments { arrayOf(EmptyGarage, Actions.Menu.Garage, Garage) },
                    Arguments { arrayOf(NewVehicle, Actions.Common.Back, Garage) },
                    Arguments { arrayOf(NewVehicle, Actions.Garage.FinishCreate, NewVehicleCreated) },
                    Arguments { arrayOf(NewVehicle, Actions.Garage.Add, NewVehicle) },
                    Arguments { arrayOf(NewVehicle, Actions.Garage.Cancel, Garage) },
                    Arguments { arrayOf(NewVehicle, Actions.Home.AddNewRecord, NewVehicle) },
                    Arguments { arrayOf(SignOut, Actions.Common.Back, SignOut) },
                    Arguments { arrayOf(VehicleDetails(10), Actions.Common.Back, Garage) },
                    Arguments { arrayOf(Home, Actions.Common.OpenMenu, Menu(Home)) },
                    Arguments { arrayOf(Home, Actions.Common.Back, ClosedApp) },
                    Arguments { arrayOf(Home, Actions.Home.AddNewRecord, AddRecordState) },
                    Arguments { arrayOf(ClosedApp, Actions.Home.AddNewRecord, ClosedApp) },
                    Arguments { arrayOf(Garage, Actions.Common.OpenMenu, Menu(Garage)) },
                    Arguments { arrayOf(Garage, Actions.Common.Back, Home) },
                    Arguments { arrayOf(Garage, Actions.Garage.Add, NewVehicle) },
                    Arguments { arrayOf(Garage, Actions.Garage.Empty, EmptyGarage) },
                    Arguments { arrayOf(Garage, Actions.Home.AddNewRecord, Garage) }
            )
        }
    }
}